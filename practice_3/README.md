# Практическая работа № 3 — ООП, Java

Решения выполнены по трём приложенным методичкам. Все программы независимы, находятся в своих каталогах и используют пакеты `ru.mirea.oop.p3.*`.

## Часть 1 — «ПР3 часть 1.pdf» (практическая работа № 5: Swing)

| Задание | Папка | Результат |
|---|---|---|
| 1 | `part_1_swing/task_01_scoreboard` | `JFrame`: счёт AC Milan / Real Madrid, последний забивший, победитель |
| 2 | `part_1_swing/task_02_shapes` | 20 случайных фигур разных цветов; абстрактный класс `Shape` |
| 3 | `part_1_swing/task_03_image_viewer` | Показ изображения из первого аргумента командной строки; прокрутка для больших изображений |
| 4 | `part_1_swing/task_04_animation` | Покадровая анимация (`BufferedImage[]` и `javax.swing.Timer`) |

## Часть 2 — «ПР3 часть 2.pdf»: статические поля и массивы объектов

| Задания | Папка | Результат |
|---|---|---|
| 1–4 | `part_2_static/task_01_04_static_analysis` | Ответы в `ANSWERS.md`; исправленные компилируемые примеры в `Main.java` |
| 5 | `part_2_static/task_05_largest_circle` | Массив `Circle[]`, поиск круга с максимальной площадью |
| 6, домашнее задание 2 | `part_2_static/task_06_stopwatch` | `StopWatch`, UML `StopWatch.drawio`, сортировка выбором 100 000 чисел |

**Время работы сортировки:** запуск без аргументов использует ровно 100 000 чисел; флаг `--quick` запускает быструю проверку на 1500 числах. Для полного опыта запускай без флага. Сортировка выбором имеет сложность O(n²), поэтому 100 000 элементов — существенная нагрузка.

## Часть 3 — «ПР3 часть 3.pdf» (практическая работа № 15: события и Swing)

| Задание | Папка | Результат |
|---|---|---|
| 1 | `part_3_swing/task_01_four_operations` | 2 текстовых поля, кнопки +, −, ×, ÷ |
| 2 | `part_3_swing/task_02_countries` | `JComboBox`: Australia, China, England, Russia |
| 3 | `part_3_swing/task_03_text_editor` | `JMenuBar` (Файл, Правка, Справка), две кнопки, `JTextArea`, сохранение UTF-8 |
| 4 | `part_3_swing/task_04_keypad_calculator` | Калькулятор 4×4 как на рисунке 15.10 |

## Сборка

Требуется JDK 11+ (протестировано под OpenJDK 21 в CI). В корне репозитория:

```bash
mkdir -p build
find practice_3 -name '*.java' -print0 | xargs -0 javac -encoding UTF-8 -d build
```

Запуск приложений:

```bash
java -cp build ru.mirea.oop.p3.part1.scoreboard.Main
java -cp build ru.mirea.oop.p3.part1.shapes.Main
java -cp build ru.mirea.oop.p3.part1.image.Main "/путь/к/фото.png"
java -cp build ru.mirea.oop.p3.part1.animation.Main

java -cp build ru.mirea.oop.p3.part2.statics.Main
java -cp build ru.mirea.oop.p3.part2.circles.Main
java -cp build ru.mirea.oop.p3.part2.stopwatch.Main

java -cp build ru.mirea.oop.p3.part3.calculator.Main
java -cp build ru.mirea.oop.p3.part3.countries.Main
java -cp build ru.mirea.oop.p3.part3.editor.Main
java -cp build ru.mirea.oop.p3.part3.keypad.Main
```

GUI требует графическую среду (запускай, например, из IntelliJ IDEA). Внутреннюю логику Swing-заданий можно проверить без окна командой `java -cp build <полный.пакет.Main> --self-test`. Файл `StopWatch.drawio` открывается в [diagrams.net](https://app.diagrams.net).

## О реализации

Код написан на Java Swing и стандартной библиотеке: дополнительные зависимости и сборщики не нужны. В интерактивных приложениях интерфейс запускается через `SwingUtilities.invokeLater`, а обработчики действий прикреплены к кнопкам через `addActionListener`. Для учебных примеров из методичек исправлены некорректные фрагменты, если они не компилируются или приводят к `NullPointerException`.

Проверка компиляции и функциональных сценариев выполняется в GitHub Actions: `.github/workflows/verify-practice3.yml`. Проверки не заменяют ручную визуальную проверку GUI.
