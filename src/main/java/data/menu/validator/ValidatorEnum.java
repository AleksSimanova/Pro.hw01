package data.menu.validator;
public class ValidatorEnum {
    public <T extends Enum<T>> boolean chechValidEnum(Class<T> enumType, String value) {
        for (T val : enumType.getEnumConstants()) {
            if (val.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
