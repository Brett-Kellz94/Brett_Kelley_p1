function getID() {
sessionStorage.setItem("userId",document.getElementById("userid").value);
}



function getTable() {
    //AJAX - Asynchronous JavaScript and XML
    //Initialize xhr object
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9090/request?employeeId="+sessionStorage.getItem("userId");

    //sets up ready state handler
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        switch (xhr.readyState) {
		
		
            case 0:
                console.log("nothing, initalized not sent");
                break;
            case 1:
                console.log("connection established")
                break;
            case 2:
                console.log("request sent");
                break;
            case 3:
                console.log("waiting response");
                break;
            case 4:
                console.log("finished");
                //logic to add request to table
                if (xhr.status === 200) {
                    console.log(xhr.responseText);
                    let requestList = JSON.parse(xhr.responseText);
                    console.log(requestList);
                    console.log(requestList[0]);
                    requestList.forEach(element => {
                        addRow(element);
                    });
                }
                break;
		
		}
	}
	//opens up the request
    xhr.open("GET", url, true);
    //sends request
    xhr.send();

	
}

let addRow = function (myRequest) {
    let table = document.getElementById("request-table");
    let tableRow = document.createElement("tr");
    let idCol = document.createElement("td");
    let dateCol = document.createElement("td");
    let costCol = document.createElement("td");
	let supCol = document.createElement("td");
	let dhCol = document.createElement("td");
	let bencoCol = document.createElement("td");

    tableRow.appendChild(idCol);
    tableRow.appendChild(dateCol);
    tableRow.appendChild(costCol);
	tableRow.appendChild(supCol);
	tableRow.appendChild(dhCol);
	tableRow.appendChild(bencoCol);
    table.appendChild(tableRow);

    idCol.innerHTML = myRequest.requestId;
    dateCol.innerHTML = myRequest.requestDate;
    costCol.innerHTML = myRequest.cost;
	supCol.innerHTML = myRequest.supervisorApproval;
	dhCol.innerHTML = myRequest.departmentHeadApproval;
	bencoCol.innerHTML = myRequest.benCoApproval;

    idCol.className = "table-style";
    dateCol.className = "table-style";
    costCol.className = "table-style";
	supCol.className = "table-style";
	dhCol.className = "table-style";
	bencoCol.className = "table-style";
    tableRow.className = "table-style";
}


//function requestSubmit(){
//	alert("Thank you for your request! Please check the update page for request status");
//
//}
////
//function requestStatus(){
//	let supApproval = document.getElementById("supApp").value;
//	let dhApproval = document.getElementById("dhApp").value;
//	let bencoApproval = document.getElementById("bencoApp").value;
//	
//	var div = document.getElementById("statusOutput");
//	var elem = document.createElement("h6");
//	
//	if (supApproval === "Approved" && dhApproval ==="Approved" && bencoApproval === "Approved"){
//		
//		elem.innerHTML = "Your reimbursement request has been approved! Please fill this form at the end of the course to submit your final grade";
//}
//	else if(supApproval === "Denied" && dhApproval ==="Denied" && bencoApproval === "Denied"){
//		
//		elem.innerHTML = "Sorry, your request has been denied by management";
//}
//	
//	else {
//		elem.innerHTML = "Request still pending approval, please check back soon"
//	}
//	
//	
//}


