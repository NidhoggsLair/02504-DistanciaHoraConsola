/* 
 * Copyright 2020 Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Calendar tiempo = Calendar.getInstance();

    public static void main(String[] args) {
//      Variables
        int h, m, s;
        int segI, segA;
        int horaCalc, minCalc, segCalc;

//      Scanner
        try {

            System.out.print("Hora inicio ......: ");
            h = SCN.nextInt();
            System.out.print("Minuto inicio ....: ");
            m = SCN.nextInt();
            System.out.print("Segundo inicio ...: ");
            s = SCN.nextInt();

//          Devolver Resultado
            System.out.println("---");

            System.out.printf("Hora actual ......: %tH/%tM/%tS %n",
                    tiempo, tiempo, tiempo);
            System.out.printf("Hora inicio ......: %02d/%02d/%02d %n", h, m, s);

//          Operacion
//          Sacar los milisegundos de inicio
            segI = h * 3600 + m * 60 + s;
//          Sacar los milisegundos actuales 
            segA = tiempo.get(Calendar.HOUR_OF_DAY) * 3600
                    + tiempo.get(Calendar.MINUTE) * 60
                    + tiempo.get(Calendar.SECOND);

//          Sacar el tiempo transcurrido entre el inicio y el actual
//          segCalc corresponde a la diferencia entre segundo actual e inicial
            segCalc = segA - segI;
            minCalc = segCalc / 60;
            segCalc = segCalc % 60;
            horaCalc = minCalc / 60;
            minCalc = minCalc % 60;

//          Devolver resultado del calculo
            System.out.printf("Tiempo de clase ..: %02d/%02d/%02d%n",
                    horaCalc, minCalc, segCalc);

        } catch (Exception e) {
//      Mensaje de Error
            System.out.println("ERROR. Entrada incorrecta.");

        } finally {
//      Limpieza de Buffer
            SCN.nextLine();
        }
    }

}
