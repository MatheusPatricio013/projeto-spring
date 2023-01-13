package com.minispring.minispring.usecase;

import com.minispring.minispring.model.InstructionInvolvement;


public class RetrieveCurrentInvolved {

    public InstructionInvolvement execute(ExistInstructionInvolvement existInstructionInvolvement){

        return existInstructionInvolvement.getCurrentInvolved();
    }
}
