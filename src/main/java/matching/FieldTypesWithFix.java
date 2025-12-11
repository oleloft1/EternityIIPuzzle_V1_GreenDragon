package matching;

import java.util.ArrayList;
import java.util.List;

public class FieldTypesWithFix extends FieldTypesBase {

    public void FieldTypesWithFix() {
        fieldList = new ArrayList<>();

        for (int i = 0; i < 256; i++) {
            fieldList.add(FieldType.C);
        }

        fieldList.set(0, FieldType.NW);
        fieldList.set(15, FieldType.NE);
        fieldList.set(240, FieldType.SW);
        fieldList.set(255, FieldType.SE);

        fieldList.set(34, FieldType.FIX_NW);
        fieldList.set(45, FieldType.FIX_NE);
        fieldList.set(151, FieldType.FIX_C);
        fieldList.set(210, FieldType.FIX_SW);
        fieldList.set(221, FieldType.FIX_SE);
    }

    public FieldType getFieldTypeToPos(int pos) {
        return fieldList.get(pos);
    }

}
