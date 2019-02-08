'''

Fourier circle program


'''
import numpy as np
import matplotlib.pyplot as plt
import scipy.io
import sys
import math

class Circle:
    center = (0,0)

    def __init__(self, radius=2, speed=(math.pi) / 8, parent=None, start_angle=0):
        self.parent = parent
        self.radius = radius
        self.speed = speed
        self.angle = start_angle
        if parent:
            self.center = next(parent.pos)
        self.start_position = (self.center[0] + self.radius * math.cos(self.angle), self.center[1] + self.radius * math.sin(self.angle))
        self.pos = self.gposition()
    def gposition(self):
        self.point = self.start_position
        while True:
            print(self.point)
            yield self.point
            if self.parent:
                self.center = next(self.parent.pos)
            self.angle += self.speed
            self.point = (self.center[0] + self.radius * math.cos(self.angle), self.center[1] + self.radius * math.sin(self.angle))

def rotations(circle, n):
    lst = []
    while circle.pos < (n * 2 * math.pi):
        lst.append(next(circle.pos)[1])
    return lst







        
