'''
Fourier approximator

The next part of the program will take in a function, and find the approximate fourier series for that function

a function is a one-variable input, output, continuous.
a0 = (1 / 2pi) * integral from -pi to pi f(x) dx
a's  (1 - whatever) = (1 / pi) * integral from -pi to pi f(x) cos(nx) dx n = 1, 2, 3, ...
b's  (1 - whatever)  = a's except sin(nx) instead of cos(nx)

f(x) ~~ a0 + sum(n=1 to inf) (an * cos(nx) + bn * sin(nx))
     ~~ a0 + a1 * cos(x) + a2 * cos(2x) + a3 * cos(3x) ...
           + b1 * sin(x) + b2 * sin(2x) + a3 * sin(3x) ...
'''
import scipy.integrate as integrate
from numpy import sqrt, sin, cos, pi


