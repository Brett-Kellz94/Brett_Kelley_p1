// JavaScript Document

window.onload = function () {
    //AJAX - Asynchronous JavaScript and XML
    //Initialize xhr object
    let xhr = new XMLHttpRequest();
    const url = "http://40.114.32.134/allRequests?employeeId="+sessionStorage.getItem("userId");
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
                //logic to add guest to table
                if (xhr.status === 200) {
                    console.log(xhr.responseText);
                    let requestList = JSON.parse(xhr.responseText);
                    console.log(requestList);
                    console.log(requestList[0]);
                    requestList.forEach(element => {
                        addRow(element);
						addOpt(element);
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

let addRow = function (Requests) {
    let table = document.getElementById("request-table");
    let tableRow = document.createElement("tr");
    let requestIdCol = document.createElement("td");
    let emplIdCol = document.createElement("td");
    let reqDateCol = document.createElement("td");
	let eventDateCol = document.createElement("td");
	let descriptionCol = document.createElement("td");
	let costCol = document.createElement("td");
	let justificationCol = document.createElement("td");
	//let attachmentCol = document.createElement("td");
	let supervisorCol = document.createElement("td");
	let dhCol = document.createElement("td");
	let bencoCol = document.createElement("td");
	

    tableRow.appendChild(requestIdCol);
    tableRow.appendChild(emplIdCol);
    tableRow.appendChild(reqDateCol);
	tableRow.appendChild(eventDateCol);
	tableRow.appendChild(descriptionCol);
	tableRow.appendChild(costCol);
	tableRow.appendChild(justificationCol);
	//tableRow.appendChild(attachmentCol);
	tableRow.appendChild(supervisorCol);
	tableRow.appendChild(dhCol);
	tableRow.appendChild(bencoCol);
    table.appendChild(tableRow);

    requestIdCol.innerHTML = Requests.requestId;
    emplIdCol.innerHTML = Requests.employeeId;
    reqDateCol.innerHTML = Requests.requestDate;
	eventDateCol.innerHTML = Requests.eventDate;
	descriptionCol.innerHTML = Requests.description;
	costCol.innerHTML = Requests.cost;
	justificationCol.innerHTML = Requests.justification;
	//attachmentCol.innerHTML = Requests.attachment;
	supervisorCol.innerHTML = Requests.supervisorApproval;
	dhCol.innerHTML = Requests.departmentHeadApproval;
	bencoCol.innerHTML = Requests.benCoApproval;
	
    requestIdCol.className = "table-style";
    emplIdCol.className = "table-style";
    reqDateCol.className = "table-style";
	eventDateCol.className = "table-style";
	descriptionCol.className = "table-style";
	costCol.className = "table-style";
	justificationCol.className = "table-style";
	//attachmentCol.className = "table-style";
	supervisorCol.className = "table-style";
	dhCol.className = "table-style";
	bencoCol.className = "table-style";
    tableRow.className = "table-style";
}
let addOpt = function(Requests){
	let dropDown = document.getElementById("requestId");
//	let Option = document.createElement("option");
//	let requestID = document.createElement();
//	requestIdOption
//	dropDown.append(document.getElementById("option").setAttribute("value",Requests.requestID).text(Requests.requestID));
	dropDown.append("<option value="+Requests.requestId+">"+Requests.requestId+"</option>");
}





