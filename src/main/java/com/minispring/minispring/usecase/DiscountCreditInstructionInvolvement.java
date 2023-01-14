package com.minispring.minispring.usecase;

import com.minispring.minispring.exception.ValueGreaterThanLimitException;
import com.minispring.minispring.model.InstructionInvolvement;
import com.minispring.minispring.model.InstructionInvolvementType;


import java.math.BigDecimal;

public class DiscountCreditInstructionInvolvement {
    public void execute(InstructionInvolvement involved, Double valueDiscount) {
        if (valueDiscount > involved.getCreditLimit().doubleValue()) {
        throw new ValueGreaterThanLimitException("This value is greater than credit!");
        }
        else{
            if (involved.getType() == InstructionInvolvementType.OBLIGOR) {
                Double discountedValue = involved.getCreditLimit().doubleValue() - valueDiscount ;
                involved.setCreditLimit(BigDecimal.valueOf(discountedValue));
            }

        }

    }
}