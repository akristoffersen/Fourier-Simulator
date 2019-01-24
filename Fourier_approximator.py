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

def finda0(func, domain):
    rng = abs(domain[0] - domain[1])
    integ = integrate.quad(func, domain[0], domain[1])[0] / (rng / 2)
    print(integ)
    return integ

def findas(func, degree, domain):
    lst = []
    rng = abs(domain[0] - domain[1])
    for i in range(1, degree + 1):
        combined = lambda x: func(x) * cos(i * x * pi / (rng / 2))
        integ = integrate.quad(combined, domain[0], domain[1])[0] / (rng / 2)
        lst.append(integ)
    print(lst)
    return lst

def findbs(func, degree, domain): 
    lst = []
    rng = abs(domain[0] - domain[1])
    for i in range(1, degree + 1):
        combined = lambda x: func(x) * sin(i * x * pi / (rng / 2))
        integ = integrate.quad(combined, domain[0], domain[1])[0] / (rng / 2)
        lst.append(integ)
    print(lst)
    return lst

def approximate(func, degree, resolution = pi / 16, domain = (0, 10)):
    a_list = [finda0(func, domain) / 2] + findas(func, degree, domain)
    b_list = findbs(func, degree, domain)
    total = None
    speed = resolution
    hrange = (abs(domain[0] - domain[1])) / 2
    i = 1
    for b in b_list:
        total = Circle(b, pi * (speed * i) / hrange, total)
        i += 1
    i = 0
    for a in a_list:
        total = Circle(a, pi * (-speed * i) / hrange, total, pi / 2)
    return total
