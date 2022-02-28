package myPackage;

public class Motivation {

    String[] quotes = {
            "«Потратив много времени на развитие голоса, не соглашайтесь хранить молчание». Мадлен Олбрайт ",
            " «У таланта без дополнительных усилий есть свои пределы». Гэри Вайнерчук",
            "«Сделайте сегодняшний день незабываемым». Зиг Зиглар",
            "«В идеале, ваша работа должна соответствовать вашей цели». Леонардо да Винчи ",
            "«Самое сложное — это действовать. Все остальное — вопрос настойчивости «. Амелия Эрхарт",
            "«Измените свое восприятие, и вы увидите, как изменится реальность». Уэйн В. Дайер",
            "«Энергия и настойчивость побеждают все на свете». Бенджамин Франклин"};


    private int number_randomizer() {
        double digit_number = Math.random();
        digit_number *= 7;
        int whole_number = (int) digit_number;
        return whole_number;
    }


    public String quote_randomizer() {
        int decider_int = number_randomizer();
        String result= quotes[decider_int];
        return result;
    }

}
