TrainScheduler Example
Train Scheduler class implements logic to add trains that arrive into a linked list and remove the trains that depart from the linked list.
addArrivals method accesses the globally declared linkedlist and adds the train to it upon arrival.
updateDepartures method also accesses the same linkedlist and removes the train from the linkedlist upon departure.
The linkedlist is globally declared and is shared by both the methods.
when 2 methods try to access the linkedlist at a time, race condition can occur.

Solution:
To solve this we have added locks to the globally shared variable so that only one thread can access the variable at any given point of time.
