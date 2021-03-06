/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.raspi;

/**
 *
 * @author Jörg
 */
public class StepperPosition {

    private double position;

    public StepperPosition() {
    }

    public StepperPosition(double position) {
        this.position = position;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }
    
    
    public void resetPosition() {
        position=0.0;
    }
    
    public void left() throws StepperPositionException {
        position=position-0.0879;
        position=Math.round(position*10000.0)/10000.0;
        if (position<0) {
            position=360+position;
            throw new StepperPositionException("Zero Degrees Exceeded!");
        }
    }
    
    public void right() throws StepperPositionException {
        position=position+0.0879;
        position=Math.round(position*10000.0)/10000.0;
        if (position>=360) {
            position=position%360;
            
            throw new StepperPositionException("Zero Degrees Exceeded!");
        }
    }

    public String toJSON() {
        return "{\"position\":"+position+"}";
    }
       
}
