package com.jsanghvi.patterns.structural.decorator;

class MeatDecorator extends SandwichDecorator {
    public MeatDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return super.make() + " + Turkey";
    }
}
