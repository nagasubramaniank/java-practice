package com.jsanghvi.patterns.structural.decorator;

class DressingDecorator extends SandwichDecorator {
    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return super.make() + " + Mustard";
    }
}
