// JavaScript Document
window.onload = function () {
    //AJAX - Asynchronous JavaScript and XML
    //Initialize xhr object
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9090/finalGrade";
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
                    let gradesList = JSON.parse(xhr.responseText);
                    console.log(gradesList);
                    console.log(gradesList[0]);
                    gradesList.forEach(element => {
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

let addRow = function (Grades) {
    let table = document.getElementById("grade-table");
    let tableRow = document.createElement("tr");
    let requestIdCol = document.createElement("td");
    let formatCol = document.createElement("td");
    let finalGradeCol = document.createElement("td");
	//let uploadCol = document.createElement("td");
	let passCol = document.createElement("td");

    tableRow.appendChild(requestIdCol);
    tableRow.appendChild(formatCol);
    tableRow.appendChild(finalGradeCol);
	//tableRow.appendChild(uploadCol);
	tableRow.appendChild(passCol);
	table.appendChild(tableRow);


    requestIdCol.innerHTML = Grades.requestId;
    formatCol.innerHTML = Grades.gradingFormat;
    finalGradeCol.innerHTML = Grades.gradeEarned;
	//uploadCol.innerHTML = Grades.upload;
	passCol.innerHTML = Grades.passingGrade;
	
    requestIdCol.className = "table-style";
    formatCol.className = "table-style";
    finalGradeCol.className = "table-style";
	//uploadCol.className = "table-style";
	passCol.className = "table-style";
	tableRow.className = "table-style";

}