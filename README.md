# TRMS- Java Azure

Tuition Reimbursement Management System (TRMS)

1	TRMS Overview
The purpose of TRMS is to provide a system that encourages quality knowledge growth relevant to an individual’s expertise.   Currently, TRMS provides reimbursements for university courses, seminars, certification preparation classes, certifications, and technical training.  The decision has been made to develop a BPM solution for this system to improve the timeliness and accuracy of approvals.  The current system relies solely on email communication, requiring manual lookups of available funds and is error-prone due to inbox clutter and incorrect routing of tasks.  Furthermore, there is no way to record and report on reimbursements awarded, and so the company has no way to identify highly-invested courses that could be developed to be offered in-house.

  
# Technologies Used

Java 8,
HTML5, CSS 3, Javascript ES6,
Web API - Javalin Server
Azure Cloud hosting,
Linux VM

# Features
List of features ready and TODOs for future development

An Employee can sumbit a reimburesment request which will be displayed in a supervior view for approval.
A supervisor can approve or deny a reimburement request which will be updated to the employee view.
Once an employee has approval from the appropriate parties, they can sumbit a grade.
The grade can then be approved or denied. If approved, the award they requested will be automatically calculated and available in their account. 

## To-do list:

Allow an employee to attach a supporting document which can be viewed by their superior.
Allow employers to send a message with their denial of a request. 
Include form and login verification.
Display employee's tuition reimburesemnt balance on the home page for ease-of-use. 

## Set-up:

Clone repo
Pull all dependencies with gradle
Connect backend to database by configuring environment variables
Start javalin server using preferred IDE
Open browser to defined local host port and begin login. 
