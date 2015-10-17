package nom.lesha.webApp01.model;


import java.math.BigDecimal;

/**
 * @author Alexey Levchenko
 */

public class Transformer {

    private int id;
    private int inputVoltage;
    private int outputVoltage;
    private int outputCurrent;
    private int mass;
    private BigDecimal price;

    public Transformer() {}

    public Transformer(int id, int inputVoltage, int outputVoltage,
                       int outputCurrent, int mass, BigDecimal price) {
        this.id = id;
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.outputCurrent = outputCurrent;
        this.mass = mass;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(int inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public int getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(int outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public int getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(int outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transformer{" +
                "id=" + id +
                ", inputVoltage=" + inputVoltage +
                ", outputVoltage=" + outputVoltage +
                ", outputCurrent=" + outputCurrent +
                ", mass=" + mass +
                ", price=" + price +'}'+
                "";
    }
}
