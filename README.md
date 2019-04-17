# Fourier-Simulator

STARTED AS:

 *** A little project I did on the plane ride coming home for winter break. The start of a Fourier series program, I'll see if I can add graphics to it and maybe make it in Java too.

NOW:

A Fourier Series visualization program. Used to display the awesome fact that almost any function can be expressed as a sum of sinosoids.

Features include:

*** An Ipython demo, showing different examples of what one can do with the Fourier Series (square wave, sawtooth) as well as an implementation of an interactive Fourier simulator, where one can input their own function and create its fourier equivalent.

*** A Java equivalent, fit with a visualizer that shows the rotating circles. Can give command line arguments to the resolution. This currently only does square waves, but can be used to create any function you want with a bit of tweaking.

To-Do:

*** Find a way to input custom functions from the command line. Do not want to create my own string->math function parser, so will probably find something else for this online. 

*** Decide on whether I should use an ArrayDeque implementation (almost equivalent to something made in CS61B) with a constant get(index) method or just deal with the slower runtime linkedList for drawing the continuous graphing in the java program. Thoughts/suggestions on this problem are greatly appreciated!
