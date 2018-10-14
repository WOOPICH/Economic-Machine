package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Window extends JFrame
{

    protected static final int WIDTH = 570;
    protected static final int HEIGHT = 640;
    private JTextField[] fields = new JTextField[18];
    private int[] costs = new int[7];
    private JLabel[] labels = new JLabel[21];
    private String[] advices = new String[3];
    private JPanel panel = new JPanel();
    private JButton calculate;
    private JButton clear;

    Window()
    {
        super("Смогли бы вы сэкономить?");
        setSize(WIDTH, HEIGHT);
        createPanel(panel);
        createLayout();
        buttonListener();
        add(panel);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("res/kek.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addLabels()
    {
        labels[0] = new JLabel("Ваш ежемесячный доход:");
        labels[0].setFont(new Font("",Font.BOLD,18));
        labels[1] = new JLabel("Заработная плата (Сколько берешь у родителей?)");
        labels[2] = new JLabel("Доход от аренды (Дальше смотри)");
        labels[3] = new JLabel("Пособие или иная социальная выплата (Стипендия? Хех...)");
        labels[4] = new JLabel("Пассивный доход (Кешбэк, Авито, Юла, СТАВКИ НА СПОРТ, блогинг и др.)");
        labels[5] = new JLabel("Сбережения");
        labels[6] = new JLabel("Иной источник дохода");
        labels[7] = new JLabel("Ваши ежемесячные расходы:");
        labels[7].setFont(new Font("",Font.BOLD,18));
        labels[8] = new JLabel("Коммунальные услуги (Живешь один, че взрослый, блен-бленский?");
        labels[9] = new JLabel("Аренда жилья");
        labels[10] = new JLabel("Погашение кредита (Че, жесткий?)");
        labels[11] = new JLabel("Образование");
        labels[12] = new JLabel("Здравоохранение");
        labels[13] = new JLabel("Кушац");
        labels[14] = new JLabel("Топ шмот");
        labels[15] = new JLabel("Уютный ламповый стафф");
        labels[16] = new JLabel("Интернет, телефон (Самое важное, да?)");
        labels[17] = new JLabel("Проезд");
        labels[18] = new JLabel("Штрафы");
        labels[19] = new JLabel("Иные расходы");
    }

    private void addFields()
    {
        for (int i = 0; i < 18; i++) {
            fields[i] = new JTextField();
            fields[i].setText("0");
        }
    }

    private void addCosts()
    {
        costs[0] = 10000;
        costs[1] = 4500;
        costs[2] = 500;
        costs[3] = 1000;
        costs[4] = 1000;
        costs[5] = 0;
        costs[6] = 1000;
    }

    private void addButtons()
    {
        calculate = new JButton("Расчитать");
        clear = new JButton("Очистить");
    }

    private void addAdvices()
    {
        advices[0]="Очевидно, Вы лишены способности принимать взвешенные финансовые\n" +
                "решения. Срочно учитесь планировать свои траты. Что можно предложить:\n" +
                "создавайте резервы под крупные покупки, для этого четко определитесь с\n" +
                "размером ежемесячного взноса в ваш резерв. Запретите себе пользоваться\n" +
                "резервом без крайней необходимости;\n" +
                "- иногда разрешайте себе расслабиться и потратить больше, чем нужно.\n" +
                "Главное, чтобы потраченная сумма не выходила за пределы выделенного\n" +
                "Вами бюджета.\n" +
                "Помните, если бы нужно было выбрать самый главный совет по обращению с\n" +
                "деньгами, гарантированно позволяющий разбогатеть каждому, совет был бы\n" +
                "таким: «Сначала инвестируйте, а потом тратьте оставшиеся деньги».";
        advices[1]="Очевидно, вам знакомо понятие «экономия».\n" +
                "Финансово состоятельные люди, когда им задают вопрос о залоге\n" +
                "финансового благополучия, отвечают: «нужно рационально, а не эмоционально\n" +
                "тратить зарабатываемые деньги». Деньги должны работать, а не\n" +
                "тратиться. Поэтому покупайте качественные вещи по низким ценам,\n" +
                "торгуйтесь, требуйте скидок.\n" +
                "Вместе с тем, не забывайте, что «Стать богатым легко. Трудно\n" +
                "продолжать быть богатым» - это слова Пола Петти, самого богатого\n" +
                "человека в мире в середине ХХ века.\n" +
                "А потому оттачивайте умение сохранять и удерживать свой капитал.";
        advices[2]="Богатый – не тот, кто зарабатывает, а тот, кто не тратит. Можно жить в\n" +
                "достатке при любом доходе, нужно лишь научиться экономить\n" +
                "правильно. Вот лишь несколько рекомендаций, которые, как\n" +
                "показывает практика, весьма эффективны:\n" +
                "- никогда не ходите в магазин на голодных желудок;\n" +
                "- после получения заработка – сразу домой, чтобы перед грядущими\n" +
                "тратами успел включиться холодный рассудок, а не горячая голова;\n" +
                "- не делайте спонтанных покупок, дайте себе несколько дней на\n" +
                "раздумья: так нужна ли Вам эта покупка;\n" +
                "- не берите в долг;\n- не давайте в долг;\n" +
                "- откажитесь от вредных привычек.\n" +
                "Еще Бенджамин Франклин сказал: «Остерегайтесь мелких напрасных\n" +
                "расходов, ибо маленькая течь может потопить большой корабль».\n" +
                "Возьмите это за правило.";
    }

    private void createPanel(JPanel panel)
    {
        addCosts();
        addAdvices();
        addFields();
        addLabels();
        addButtons();
        for (int j = 0; j < 18; j++) {
            panel.add(fields[j]);
        }
    }

    private boolean checkFields()
    {
        for(int i=0;i<18;i++)
        {
            try
            {
                if(Integer.parseInt(fields[i].getText())<0)
                {
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    private void buttonListener()
    {
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setText("0");
                }
            }
        });

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monthlyIncome = 0;
                double monthOutcome = 0;
                double monthOutcomeNeeded = 0;
                double procentOfEconomy = 0;
                if (checkFields()) {
                    for (int i = 0; i < 6; i++) {
                        monthlyIncome += Integer.parseInt(fields[i].getText());
                    }
                    for (int i = 6; i < 18; i++) {
                        monthOutcome += Integer.parseInt(fields[i].getText());
                    }
                    if (monthlyIncome - monthOutcome >= 0) {
                        for (int i = 11; i < 18; i++) {
                            if (Integer.parseInt(fields[i].getText()) > costs[i - 11]) {
                                monthOutcomeNeeded += Integer.parseInt(fields[i].getText()) - costs[i - 11];
                            }
                        }
                        if (monthOutcomeNeeded > 0) {
                            procentOfEconomy = new BigDecimal((monthOutcomeNeeded / (monthlyIncome / 100))).setScale(2, RoundingMode.UP).doubleValue();
                        }
                        if (procentOfEconomy > 20) {
                            JOptionPane.showMessageDialog(null, "Месячный доход: " + (int) monthlyIncome + " р" + "\nМесячный расходы: " + (int) monthOutcome + " р" + "\nВы можете экономить до: " + (int) monthOutcomeNeeded + " р" + "\nСумма экономии в процентах: " + procentOfEconomy + "%" + "\nСовет:\n" + advices[0], "Вывод", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (procentOfEconomy >= 5 && procentOfEconomy <= 20) {
                            JOptionPane.showMessageDialog(null, "Месячный доход: " + (int) monthlyIncome + " р" + "\nМесячный расходы: " + (int) monthOutcome + " р" + "\nВы можете экономить до: " + (int) monthOutcomeNeeded + " р" + "\nСумма экономии в процентах: " + procentOfEconomy + "%" + "\nСовет:\n" + advices[1], "Вывод", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (procentOfEconomy < 5) {
                            JOptionPane.showMessageDialog(null, "Месячный доход: " + (int) monthlyIncome + " р" + "\nМесячный расходы: " + (int) monthOutcome + " р" + "\nВы можете экономить до: " + (int) monthOutcomeNeeded + " р" + "\nСумма экономии в процентах: " + procentOfEconomy + "%" + "\nСовет:\n" + advices[2], "Вывод", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        String[] options = {"Да", "Нет"};
                        if (JOptionPane.showOptionDialog(null, "Вы уверены что тратите больше чем зарабатываете?", "Проверка", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
                            JOptionPane.showMessageDialog(null, "Учитесь экономить", "Вывод", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Заполните корректно все поля", "Проверка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void createLayout()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[0])
                        .addComponent(labels[1])
                        .addComponent(labels[2])
                        .addComponent(labels[3])
                        .addComponent(labels[4])
                        .addComponent(labels[5])
                        .addComponent(labels[6])
                        .addComponent(labels[7])
                        .addComponent(labels[8])
                        .addComponent(labels[9])
                        .addComponent(labels[10])
                        .addComponent(labels[11])
                        .addComponent(labels[12])
                        .addComponent(labels[13])
                        .addComponent(labels[14])
                        .addComponent(labels[15])
                        .addComponent(labels[16])
                        .addComponent(labels[17])
                        .addComponent(labels[18])
                        .addComponent(labels[19])
               )
                .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(fields[0], 80, 80,
                                        80)
                                .addComponent(fields[1], 80, 80,
                                        80)
                                .addComponent(fields[2], 80, 80,
                                        80)
                                .addComponent(fields[3], 80, 80,
                                        80)
                                .addComponent(fields[4], 80, 80,
                                        80)
                                .addComponent(fields[5], 80, 80,
                                        80)
                                .addComponent(fields[6], 80, 80,
                                        80)
                                .addComponent(fields[7], 80, 80,
                                        80)
                                .addComponent(fields[8], 80, 80,
                                        80)
                                .addComponent(fields[9], 80, 80,
                                        80)
                                .addComponent(fields[10], 80, 80,
                                        80)
                                .addComponent(fields[11], 80, 80,
                                        80)
                                .addComponent(fields[12], 80, 80,
                                        80)
                                .addComponent(fields[13], 80, 80,
                                        80)
                                .addComponent(fields[14], 80, 80,
                                        80)
                                .addComponent(fields[15], 80, 80,
                                        80)
                                .addComponent(fields[16], 80, 80,
                                        80)
                                .addComponent(fields[17], 80, 80,
                                        80)
                                .addComponent(clear, 100, 100, 100)
                                .addComponent(calculate, 100, 100, 100))));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[0]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[1])
                        .addComponent(fields[0]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[2])
                        .addComponent(fields[1]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[3])
                        .addComponent(fields[2]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[4])
                        .addComponent(fields[3]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[5])
                        .addComponent(fields[4]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[6])
                        .addComponent(fields[5]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[7]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[8])
                        .addComponent(fields[6]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[9])
                        .addComponent(fields[7]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[10])
                        .addComponent(fields[8]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[11])
                        .addComponent(fields[9]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[12])
                        .addComponent(fields[10]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[13])
                        .addComponent(fields[11]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[14])
                        .addComponent(fields[12]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[15])
                        .addComponent(fields[13]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[16])
                        .addComponent(fields[14]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[17])
                        .addComponent(fields[15]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[18])
                        .addComponent(fields[16]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labels[19])
                        .addComponent(fields[17]))
                .addComponent(clear)
                .addComponent(calculate)
        );
    }
}
