# Attendance Management System based on SpringBoot 3.1.x

### APIs
* Person Add
* Person View
* Person Update
* Attendance Add
* Attendance View

### Working:
#### Person Add: Post Request /person/add
Request:
{
    "personName": "Nikket Chandwani",
    "personAge": "24",
    "jobType": "IT"
}

Response:

{
    "data": {
        "personId": 23,
        "personName": "Nikket Chandwani",
        "personAge": "24",
        "jobType": "IT"
    },
    "message": "Successfully added Person ",
    "

#### Person View: Get Request : /person/view/{id}

Request: 

Response: 
{
    "data": {
        "personId": 1,
        "personName": "Nikket C",
        "personAge": "1",
        "jobType": "IT"
    },
    "message": "Below",
    "status": 200
}

#### Update Person: Put Request: /person/update/{id}

Request: 
{
    "personAge": "23",
    "jobType": "RBL Bank"
}

Response:
{
    "data": {
        "personId": 2,
        "personName": "Nikket C",
        "personAge": "23",
        "jobType": "RBL Bank"
    },
    "message": "Update Successful",
    "status": 200
}


#### Attendance Add: attendance/{id}/add/

Request: 
{
    
}

Response:
{
    "data": {
        "attendanceId": 10,
        "attendanceDateTime": "21/07/23"
    },
    "message": "Successfully added Attendance ",
    "status": 200
}

#### Attendance View: attendance/{id}/view/

Request:
Response:
{
    "data": "[AttendanceDTO{attendanceId=14, attendanceDateTime='2023-07-21'}]",
    "message": "Viewing person ",
    "status": 200
}
