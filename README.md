# Final project

In the final education project the next next patterns have been implemented:

1. Page object
2. Steps
3. Chain of invocations
4. Loadable component

[finalsurge](https://www.finalsurge.com/) was used as testing product.

# Test suite

## Test case 1 - Log out

| step #        | desc                                                           | expected result                   |
|---------------|----------------------------------------------------------------|-----------------------------------|
| 1             | open [finalsurge](https://www.finalsurge.com/)                 | login page opens                  |
| 2             | login                                                          | calendar opens                    |
| 3             | click 'Logout' link                                            | Logout page opens                 |


## Test case 2 - Add a new workout

| step #        | desc                                                           | expected result                                   |
|---------------|----------------------------------------------------------------|---------------------------------------------------|
| 1             | open [finalsurge](https://www.finalsurge.com/)                 | login page opens                                  |
| 2             | login                                                          | calendar opens                                    |
| 3             | hover 'Workouts'in main menu                                   | menu expands                                      |
| 4             | click 'Add Workout'                                            | 'Add Workout' page opens                          |
| 5             | click Activity type in left menu                               | Activity type expands, 'Add new workout' form opens |
| 6             | click subtype                                                  | 'Add new workout' is showing up                   |
| 7             | fill in all fields on form -> click 'Add workout'              | details page for added workout opens              |
| 8             | make sure filled workout's data matches data on 'Details' page | filled workout's data matches data on 'Details' page |
| Postcondition | remove added workout                                           | added test workout was removed                    |


## Test case 3 - Update added workout

| step #        | desc                                                           | expected result                                      |
|---------------|----------------------------------------------------------------|------------------------------------------------------|
| Precondition  | run steps ##1-7 Test case 2                                    | workout is added                                     |
| 1             | click 'Update Workout'                                         | 'Update workout'page opens                           |
| 2             | update some data -> click 'Update Workout'                     | details page for added workout opens                 |
| 3             | make sure filled workout's data matches data on 'Details' page | filled workout's data matches data on 'Details' page |
| Postcondition | remove added workout                                           | added test workout was removed                       |


## Test case 4 - Add Daily Vitals

| step #        | desc                                                                      | expected result                                   |
|---------------|---------------------------------------------------------------------------|---------------------------------------------------|
| 1             | open [finalsurge](https://www.finalsurge.com/)                            | login page opens                                  |
| 2             | login                                                                     | calendar opens                                    |
| 3             | hover 'Daily Vitals'in main menu                                          | menu expands                                      |
| 4             | click 'View & Add Vitals'                                                 | 'Daily Vitals' page opens                         |
| 5             | click 'Add Vitals'                                                        | 'Daily Vitals Add' form opens                     |
| 6             | fill in all fields on form -> click 'Add Vitals'                          | 'Daily Vitals' page opens                         |
| 7             | click 'Custom View'                                                       | 'Custom View' filter expands                      |
| 8             | fill 'Date' (from step #6) in 'Start Date' and 'End Date' -> click 'View' | Only one added vitals is showing                  |
| 9             | make sure filled vitals data matches data on 'Details' page               | filled vitals data matches data on 'Details' page |
| Postcondition | remove added vitals                                                       | added test workout was vitals                     |


## Test case 5 - Update added Daily Vitals

| step #        | desc                                                                      | expected result                                   |
|---------------|---------------------------------------------------------------------------|---------------------------------------------------|
| Precondition  | run steps ##1-8 Test case 4                                               | Only one added vitals is showing                  |
| 1             | click 'Date' cell                                                         | 'Edit Vitals' form opens                          |
| 2             | update some data -> click 'Edit Vitals'                                   | 'Daily Vitals' page opens                         |
| 3             | click 'Custom View'                                                       | 'Custom View' filter expands                      |
| 4             | fill 'Date' (from step #6) in 'Start Date' and 'End Date' -> click 'View' | Only one added vitals is showing                  |
| 5             | make sure filled vitals data matches data on 'Details' page               | filled vitals data matches data on 'Details' page |
| Postcondition | remove added vitals                                                       | added test vitals was removed                     |


To start test suite exec cmd command:
```mvn clean test```