# Healthcare-pushD

SELF HELP APP FOR DEPRESSION THERAPY

Typically, a psychiatrist/psychologist/therapist (doctor) would recommend that their patientuse this app if they are diagnosed 
with mild to medium levels of depression. An individual canalso directly decide to use the app. In either case, 
they self-register into the app using theiremail for verification. 
This email id is also needed for subsequent interactions/notifications.Certain actions are needed during the registration process such as “accepting” terms andconditions.

-> PATIENT

The patient/user can optionally connect themselves to a doctor using a code obtained fromthe doctor. This will allow the doctor to monitor their progress, communicate with them etc.
No other doctor will be able to see the specific information about the user.

The app enables a structured navigation through the content of the app, which is organized asa series of sections, each with sub-sections.
A user can move from one sub-section to the next,only aer completing the current sub-section. On completing a section, the system guidesthem to the next section, 
based on some rules and choices of the user or doctor and the usagehistory of the user.

Each subsection consists of a set of “exercises”. We will implement a set of sections/subsections to illustrate the different types of exercises andinteraction modes - MCQʼs as well as filling in and editing tables.
Patients can view their past work and completed sections, though not edit it.

Various features are added in the app to encourage users to progress through the app:progress bars, reminders, some acknowledgements, BoreDom API etc.

Patient will able to deactivate himself/herself completely from the app which will deletes all his/her all data from the system.

-> DOCTOR

Dashboard for a doctor to get an overview and manage their patients

A doctor can generate a code for each patient and share with them, to be used to connectpatient to doctor. Other mechanisms for this will also be explored.

A doctor can see the list of patients under their care, and be able to filter outactive/inactive/completed status.

For each patient, the doctor can get a snapshot of their progress, and some statistics onusage. There is a message type chat service for the doctor to get notes from the patient and to also providefeedback.

The doctor can “plan” the set of sections and the sequence that guides the patientʼsnavigation through the app.
Doctor can also force reset the section order set.

-> SPECIALIST

Does not directly interact with the patients.

Coordinates a set of doctors, who in turn treat a set of patients.

Two way communication between specialist and individual or all doctors in their list.

A Patient can enable read access to their data to the specialist.

-> ADMIN

Admin role to manage doctors and specialist etc.
