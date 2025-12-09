# EternityIIPuzzle_V1_GreenDragon
Eternity II Puzzle

## This is my atempt to find a solution for the puzzle game Eternity II Puzzle.
The idear behind this approach is pure brute force. The generel datastructure is to try to use an integer to hold one piece. 5 bit is needed to hold each piece side, meaning 5 bit x 4 puzzle sides = 20 bit is needed to hold one piece. The program will not rotate each piece but when all pieces are generated there will be generated a rotated pice as well. So in the piece list it will occur 4 times. This is haveing the benefit of no need to rotate each piece but at the cust of the piece list is not with 256 pieces but 1024 pieces. To reach 1024, 10 bit is needed so if we add this to the 20 color pieces, we use 20 + 10 = 30 pieces. This means the system only needs one integer pr pice.

### More to come later

