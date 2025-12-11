package matching;

import java.util.ArrayList;
import java.util.List;

public class FieldTypesNoFix extends FieldTypesBase {

    public FieldTypesNoFix() {
        fieldList = new ArrayList<>();

        for (int i = 0; i < 256; i++) {
            fieldList.add(FieldType.C);
        }

        fieldList.set(0, FieldType.NW);
        fieldList.set(15, FieldType.NE);
        fieldList.set(240, FieldType.SW);
        fieldList.set(255, FieldType.SE);
    }

    public FieldType getFieldTypeToPos(int pos) {
        return fieldList.get(pos);
    }
}
