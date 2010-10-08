package br.unoesc.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author INFOVITOR-SERVER
 */
public class Validacoes {

    public static boolean validaCPF(String cpfString) {
        Integer cpf[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};

        if (cpfString.length() != 11 && cpfString.length() != 14) {
            return false;
        }
        if (cpfString.length() == 14) {
            cpfString = cpfString.substring(0, 3) + cpfString.substring(4, 7) +
                    cpfString.substring(8, 11) + cpfString.substring(12, 14);
        }

        if (cpfString.length() == 11) {
            for (int i = 0; i < 11; i++) {
                cpf[i] = Integer.valueOf(cpfString.substring(i, i + 1));
            }
        }

        int[] pesos = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int resto, dv1, dv2, acc = 0;

        for (int i = 0; i < 9; i++) {

            acc += cpf[i] * pesos[i + 1];
        }
        resto = acc % 11;

        if (resto == 0 || resto == 1) {
            dv1 = 0;
        } else {
            dv1 = 11 - resto;
        }

        acc = 0;

        if (dv1 == ((int) cpf[9])) {
            for (int i = 0; i < 9; i++) {
                acc += ((int) cpf[i]) * pesos[i];
            }
            acc += (dv1 * 2);
            resto = acc % 11;

            if (resto == 0 || resto == 1) {
                dv2 = 0;
            } else {
                dv2 = 11 - resto;
            }

            if (dv2 == (int) cpf[10]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    static public boolean validaCNPJ(String str_cnpj) {

//          34.344.123/1111-11
//          012345678901234567


        int soma = 0, dig;
        String cnpj_calc = str_cnpj.substring(0, 12);

        if (str_cnpj.length() != 14) {
            return false;
        }
        char[] chr_cnpj = str_cnpj.toCharArray();

        /* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);

        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

        /* Segunda parte */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

        return str_cnpj.equals(cnpj_calc);

    }

    public static Date validaData(String data) throws ParseException {
        Date DateRetorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            DateRetorno = sdf.parse(data);
        } catch (ParseException e) {
            DateRetorno = null;
        }
        return DateRetorno;
    }

    public static String formataData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataF = sdf.format(data);
        return dataF;
    }

    public static String formataDataComHora(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataF = sdf.format(data);
        return dataF;
    }

    public static MaskFormatter getMaskData() {

        MaskFormatter maskData = null;
        try {

            maskData = new MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
            maskData.setValidCharacters("1234567890");
            maskData.setOverwriteMode(true);
        } catch (Exception e) {
        }
        return maskData;

    }

    public static MaskFormatter getMaskCpf() {
        MaskFormatter maskCpf = null;

        try {

            maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.setPlaceholderCharacter('0');
            maskCpf.setValidCharacters("1234567890");
            maskCpf.setOverwriteMode(true);
        } catch (ParseException ex) {
        }
        return maskCpf;
    }

    public static MaskFormatter getMaskCnpj() {
        MaskFormatter maskCpf = null;

        try {

            maskCpf = new MaskFormatter("##.###.###/####-##");
            maskCpf.setPlaceholderCharacter('0');
            maskCpf.setValidCharacters("1234567890");
            maskCpf.setOverwriteMode(true);
        } catch (ParseException ex) {
        }
        return maskCpf;
    }

    public static MaskFormatter getMaskTelefone() {
        MaskFormatter maskCpf = null;

        try {

            maskCpf = new MaskFormatter("(##)####-####");
            maskCpf.setPlaceholderCharacter('0');
            maskCpf.setValidCharacters("1234567890");
            maskCpf.setOverwriteMode(true);
        } catch (ParseException ex) {
        }
        return maskCpf;
    }

    public static Date adicionaDiasEmData(Date d, int dias) {

        GregorianCalendar gr = new GregorianCalendar();
        gr.setTime(d);
        gr.add(GregorianCalendar.DAY_OF_MONTH, dias);

        return gr.getTime();
    }

    public static String retornaDiaDeUmaData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(data);
    }

    public static String retornaAnoDeUmaData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(data);
    }

    public static String retornaMesExtensoDeUmaData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int mes = (int) Integer.valueOf(sdf.format(data));

        switch (mes) {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
            default:
                return null;

        }
    }

    public static Object[] retornaDataExtenso(Date data) {
        Object[] comp = new Object[3];
        comp[0] = retornaDiaDeUmaData(data);
        comp[1] = retornaMesExtensoDeUmaData(data);
        comp[2] = retornaAnoDeUmaData(data);
        return comp;
    }
}
    
