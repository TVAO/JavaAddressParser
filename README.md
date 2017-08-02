AddressParser
=============
1)
You must write a function for parsing user text input as an address (you decide how user input is provided).
There is no final answer to this part; any solution can always be improved to handle more special cases.
A useful toolset for this task is that of regular expressions.
2)
You must write a simple MVC-based user interface that lets a user input addresses,
and displays the addresses in a way that reflects how the addresses have been parsed.
This does not have to be interactive; it is fine to only allow user input at startup, though interactive is better.

Specifically, you must complete the public static Address parse(String s) {...} method of the class Address.java.
You must not change anything else about that class, as your solution will be a part of later exercises.

The rest of the program should as a minimum include the following classes:
Model.java: stores the entered addresses
View.java: displays the entered addresses in a window
Controller.java: handles user input

Hand hand-in must consist of three files>
1) A .jar file that can be run, and which also contains the source code
2) A screen shot of the program window, showing the awesome graphics you have made.
3) A .txt file with instructions for how to run the program (i.e. are the addresses given in a file,
or on the command line, or have you actually made a proper gui), and any requests for feedback about your solution.
