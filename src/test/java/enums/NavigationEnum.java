package enums;

public class NavigationEnum {
    public enum AppMainTabs {
        CREDIT_CARDS("Кредитные карты"),
        DEBIT_CARDS("Дебетовые карты"),
        CREDIT_CASH("Кредит наличными"),
        MORTGAGE("Ипотека"),
        DEPOSITS("Вклады"),
        PAYMENTS("Платежи");

        String id;
        private AppMainTabs(String id) {
            this.id = id;
        }
        public String get() {
            return this.id;
        }
    }
}
