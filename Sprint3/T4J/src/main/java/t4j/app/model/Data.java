package t4j.app.model;

import java.util.Calendar;
import java.util.Objects;
import t4j.app.exception.DiaInvalidoException;
import t4j.app.exception.MesInvalidoException;

public class Data implements Comparable<Data> {

    /**
     * 
     */
    private int ano;
    
    /**
     * 
     */
    private Mes mes;
    
    /**
     * 
     */
    private int dia;

    /**
     * 
     */
    private static final int ANO_POR_OMISSAO = 1;
    
    /**
     * 
     */
    private static final Mes MES_POR_OMISSAO = Mes.JANEIRO;
    
    /**
     * 
     */
    private static final int DIA_POR_OMISSAO = 1;

    
    /**
     * 
     */
    private static enum DiaDaSemana {
        
        DOMINGO { @Override public String toString() { return "Domingo"; } },
        SEGUNDA { @Override public String toString() { return "Segunda-Feira"; } },
        TERCA {   @Override public String toString() { return "Terça-Feira"; } },
        QUARTA {  @Override public String toString() { return "Quarta-Feira"; } },
        QUINTA {  @Override public String toString() { return "Quinta-Feira"; } },
        SEXTA {   @Override public String toString() { return "Sexta-Feira"; } },
        SABADO {  @Override public String toString() { return "Sábado"; } };
        
        /**
         * 
         * @param ordemDiaDaSemana
         * @return 
         */
        public static String designacaoDiaDaSemana(int ordemDiaDaSemana) {
            return DiaDaSemana.values()[ordemDiaDaSemana].toString();
        }
    }
    
    /**
     * 
     */
    private static enum Mes {

        JANEIRO(31) {   @Override public String toString() { return "Janeiro"; } }, 
        FEVEREIRO(28) { @Override public String toString() { return "Fevereiro"; } }, 
        MARCO(31) {     @Override public String toString() { return "Março"; } },
        ABRIL(30) {     @Override public String toString() { return "Abril"; } }, 
        MAIO(31) {      @Override public String toString() { return "Maio"; } }, 
        JUNHO(30) {     @Override public String toString() { return "Junho"; } }, 
        JULHO(31) {     @Override public String toString() { return "Julho"; } }, 
        AGOSTO(31) {    @Override public String toString() { return "Agosto"; } }, 
        SETEMBRO(30) {  @Override public String toString() { return "Setembro"; } },
        OUTUBRO(31) {   @Override public String toString() { return "Outubro"; } }, 
        NOVEMBRO(30) {  @Override public String toString() { return "Novembro"; } }, 
        DEZEMBRO(31) {  @Override public String toString() { return "Dezembro"; } };

        
        /**
         * 
         */
        private int numeroDeDias;

        
        /**
         * 
         * @param numeroDeDias 
         */
        private Mes(int numeroDeDias) {
            this.numeroDeDias = numeroDeDias;
        }
        
        /**
         * 
         * @param ano
         * @return 
         */
        public int numeroDeDias(int ano) {
            if (ordinal() == 1 && Data.isAnoBissexto(ano)) {
                return numeroDeDias + 1;
            }
            return numeroDeDias;
        }

        /**
         * 
         * @param ordemDoMes
         * @return 
         */
        public static Mes obterMes(int ordemDoMes) {
            return Mes.values()[ordemDoMes - 1];
        }

    }

    /**
     * 
     * @param ano
     * @param mes
     * @param dia 
     */
    public Data(int ano, int mes, int dia) {
        setData(ano,mes,dia);
    }

    /**
     * 
     */
    public Data() {
        ano = ANO_POR_OMISSAO;
        mes = MES_POR_OMISSAO;
        dia = DIA_POR_OMISSAO;
    }

    /**
     * 
     * @param outraData 
     */
    public Data(Data outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }

    /**
     * 
     * @return 
     */
    public int getAno() {
        return ano;
    }

    /**
     * 
     * @return 
     */
    public int getMes() {
        return mes.ordinal()+1;
    }

    /**
     * 
     * @return 
     */
    public int getDia() {
        return dia;
    }

    /**
     * 
     * @param ano ano
     * @param mes mês
     * @param dia dia
     */
    public final void setData(int ano, int mes, int dia) {
        if (mes < 1 || mes > 12) {
            throw new MesInvalidoException(String.format("Mês %02d é inválido!!", mes));
        }
        if (dia < 1 || dia > Mes.obterMes(mes).numeroDeDias(ano))  {
            throw new DiaInvalidoException(String.format("Dia %04d/%02d/%02d é inválido!!", ano, mes, dia));
        }
        this.ano = ano;         
        this.mes = Mes.obterMes(mes);       
        this.dia = dia;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia, mes, ano);
    }

    /**
     * 
     * @return 
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes.ordinal()+1, dia);
    }

    /**
     * 
     * @param outroObjeto
     * @return 
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Data outraData = (Data) outroObjeto;
        return ano == outraData.ano
                && mes.equals(outraData.mes)
                && dia == outraData.dia;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.ano;
        hash = 31 * hash + Objects.hashCode(this.mes);
        hash = 31 * hash + this.dia;
        return hash;
    }

    /**
     * 
     * @param outraData data a comparar passada por parâmetro
     * @return 
     */
    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }

    /**
     * 
     * @return o dia da semana
     */
    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;
        return DiaDaSemana.designacaoDiaDaSemana(totalDias);
    }

    /**
     * 
     * @param outraData data a comparar passada por parâmetro
     * @return true se data for maior que data passada por parâmetro e false se contrário
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();
        return totalDias > totalDias1;
    }

    /**
     * 
     * @param outraData data a comparar passada por parâmetro
     * @return diferença de dias entre uma data e outra passada por parâmetro
     */
    public int diferenca(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();
        return Math.abs(totalDias - totalDias1);
    }

    /**
     * 
     * @param ano ano
     * @param mes mês
     * @param dia dia
     * @return diferença de dias entre uma data e outra passada por parâmetro em dia, mês e ano
     */
    public int diferenca(int ano, int mes, int dia) {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contaDias();
        return Math.abs(totalDias - totalDias1);
    }

    /**
     * 
     * @param ano ano a verificar se é Bissexto
     * @return true se bissexto e false se contrário
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * 
     * @return retorna  a data do sistema
     */
    public static Data dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0.
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia);
    }

    /**
     * 
     * @return conta o número de dias
     */
    private int contaDias() {
        int totalDias = 0;
        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes.ordinal()+1; i++) {
            totalDias += Mes.obterMes(i).numeroDeDias(ano);
        }
        totalDias += dia;
        return totalDias;
    }
}
