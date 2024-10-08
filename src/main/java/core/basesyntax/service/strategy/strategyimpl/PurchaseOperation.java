package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());
        int purchaseQuantity = transaction.getQuantity();
        if (currentQuantity == null && currentQuantity < 0) {
            throw new IllegalArgumentException("Invalid quantity of for purchase.");
        }
        int newQuantity = currentQuantity - purchaseQuantity;
        Storage.storage.put(transaction.getFruit(), newQuantity);
    }
}

