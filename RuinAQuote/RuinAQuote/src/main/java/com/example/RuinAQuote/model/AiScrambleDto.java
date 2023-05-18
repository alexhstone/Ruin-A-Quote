package com.example.RuinAQuote.model;

public class AiScrambleDto {

    private String model = "text-davinci-edit-001";
    private String input;
    private String instruction;

    public AiScrambleDto() {
    }

    public AiScrambleDto(String input, String instruction) {
        this.input = input;
        this.instruction = instruction;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
