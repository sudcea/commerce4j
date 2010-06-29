/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dto;

/**
 *
 * @author Ignatiues charles Arun
 */
public class HelpDTO {
    private int question_id;
    private String question;
    private String question_description;

    /**
     * Java Bean, Getter get the value of question
     * @return the value of question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Java Bean Setter, Set the value to question
     * @param Store the value to question
     */

    public void setQuestion(String question) {
        this.question = question;
    }

/**
     * Java Bean Getter, get the value of question_description
     * @param return the value of question_description
     */
    public String getQuestion_description() {
        return question_description;
    }

    /**
     * Java Bean Setter, Set the value to question_description
     * @param Store the value to question_description
     */

    public void setQuestion_description(String question_description) {
        this.question_description = question_description;
    }

    /**
     * Java Bean Getter, get the value of Question_id
     * @return return the value of Question_id
     */
    public int getQuestion_id() {
        return question_id;
    }

    /**
     * Java Bean Setter, Set the value to question_id
     * @param Store the value to question_id
     */

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }




}
