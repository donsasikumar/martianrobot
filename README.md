# martianrobot

Martian Robot moves around mars following instructions from Earth.

The robot  moves around a rectangular grid with x and y cordinates, starting from 0,0 to 
a maximum of given input.
If it goes out of this grid, it is lost.
Although lost, the robot still carries on.

This project was implemented using TDD. 

MartianRobot is the main class. Here is how you input ending with an exit instruction.

5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL
exit

Here is the sample output

1 1 E
3 3 N LOST
2 4 S LOST


To understand the implementation, please use the tests.
LineProcessorTest is a good starting point.