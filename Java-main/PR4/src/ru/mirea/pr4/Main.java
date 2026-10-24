package ru.mirea.pr4;

/** Демонстрация задания 1 практической работы 4 «Времена года». */
public class Main {

    /** Выводит фразу о любимом времени года, используя switch. */
    public static void printFavoriteSeason(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Люблю зиму");
                break;
            case SPRING:
                System.out.println("Люблю весну");
                break;
            case SUMMER:
                System.out.println("Люблю лето");
                break;
            case AUTUMN:
                System.out.println("Люблю осень");
                break;
            default:
                System.out.println("Время года не определено");
        }
    }

    public static void main(String[] args) {
        // Для примера в качестве любимого выбрано лето.
        Season favoriteSeason = Season.SUMMER;

        System.out.println("Любимое время года: " + favoriteSeason);
        System.out.println("Средняя температура: "
                + favoriteSeason.getAverageTemperature() + " °C");
        System.out.println("Описание: " + favoriteSeason.getDescription());
        printFavoriteSeason(favoriteSeason);

        System.out.println("\nВсе времена года:");
        for (Season season : Season.values()) {
            System.out.printf("%s — средняя температура: %d °C; %s%n",
                    season, season.getAverageTemperature(), season.getDescription());
        }
    }
}
