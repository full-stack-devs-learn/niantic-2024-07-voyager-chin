class Car:
    def __init__(self, make, model):
        self.make = make
        self.model = model

    def turnOn(self):
        print(f'{self.make} {self.model} is on')


class Mower:
    def __init__(self, bladeSpeed):
        self.bladeSpeed = bladeSpeed

    def turnOn(self):
        print(f'Mower is on with bladeSpeed of {self.bladeSpeed}')
    

# Python allows multiple inheritance
class RidingMower(Mower,Car):
    def __init__ (self, make, model, bladeSpeed):
        Car.__init__(self, make, model)
        Mower.__init__(self, bladeSpeed)

    def turnOn(self):
        Car.turnOn(self)
        Mower.turnOn(self)




mower = RidingMower("Toro", "XL5500", 2000)
mower.bladeSpeed = 500
mower.turnOn()