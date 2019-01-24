'''
Fourier approximator

The next part of the program will take in a function, and find the approximate fourier series for that function

a function is a one-variable input, output, continuous. uses variable x (lambda)
a0 = (1 / 2pi) * integral from -pi to pi f(x) dx
a's  (1 - whatever) = (1 / pi) * integral from -pi to pi f(x) cos(nx) dx   n = 1, 2, 3, ...
b's  (1 - whatever)  = a's except sin(nx) instead of cos(nx)

f(x) ~~ a0 + sum(n=1 to inf) (an * cos(nx) + bn * sin(nx))
     ~~ a0 + a1 * cos(x) + a2 * cos(2x) + a3 * cos(3x) ...
           + b1 * sin(x) + b2 * sin(2x) + a3 * sin(3x) ...
'''
import scipy.integrate as integrate
from numpy import sqrt, sin, cos, pi
import Circle
import rotations
# not useful
def finda0(func):
    integ = integrate.quad(func, -pi, pi)[0]

def findas(func, degree):
    lst = []
    for i in range(1, degree + 1):
        combined = lambda x: func(x) * cos(i * x)
        integ = integrate.quad(combined, -pi, pi)[0]
        lst.append(integ)
    return lst
##
def findbs(func, degree): 
    lst = []
    for i in range(1, degree + 1):
        combined = lambda x: func(x) * sin(i * x)
        integ = integrate.quad(combined, -pi, pi)[0]
        lst.append(integ)
    return lst

def approximate(func, degree, resolution = pi / 16):
    a_list = [finda0(func)] + findas(func, degree) #only used if we care about x position.
    b_list = findbs(func, degree)
    total = None
    speed = resolution
    i = 1
    for b in b_list:
        total = Circle(b, speed * i, total)
        i += 1
    return total

