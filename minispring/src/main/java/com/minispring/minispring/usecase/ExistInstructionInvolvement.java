package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ListIsEmptyException;
import com.minispring.minispring.model.InstructionInvolvement;


import java.util.List;
import java.util.Scanner;

public class ExistInstructionInvolvement {
    Scanner scan = new Scanner(System.in);
    private InstructionInvolvement currentInvolved = new InstructionInvolvement();
    public Boolean execute(List<InstructionInvolvement> involveds) {
        if (!involveds.isEmpty()) {
            Boolean isCnpjExiste = false;
            while (!isCnpjExiste) {

                System.out.println("Digite seu CPF/CNPJ  para validação:");
                String identificationValue = scan.nextLine();

                for (InstructionInvolvement in : involveds) {
                    if (in.getOrderInvolvement().getParty().getIdentification().getValue().equals(identificationValue)) {
                        System.out.printf("CNPJ encontrado! Bem-vindo %s%n", in.getOrderInvolvement().getParty().getName());
                        currentInvolved = in;
                        System.out.println("Current involved: \n" + currentInvolved);
                        isCnpjExiste = true;
                    }
                }
                if (!isCnpjExiste) {
                    System.out.println("CNPJ não encontrado! Verifique se digitou os dados corretamente!");
                } else {
                    return true;
                }
            }

        } else {
            throw new ListIsEmptyException("The list cannot be empty");

        }
        return false;
    }

    public InstructionInvolvement getCurrentInvolved() {
        return currentInvolved;
    }
}

