package com.mystreams.main;

import com.mystreams.dominio.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class MinhaClasse {

    private static List<Installment> myInstallments = new ArrayList(List.of(
            new Installment(0, LocalDate.of(2024,2,15),1729.41, "S"),
            new Installment(1, LocalDate.of(2024,3,15),1729.41, "S"),
            new Installment(2, LocalDate.of(2024,4,15),1729.41, "S"),
            new Installment(3, LocalDate.of(2024,5,15),1729.41, "N"),
            new Installment(4, LocalDate.of(2024,6,15),1729.41, "N"),
            new Installment(5, LocalDate.of(2024,7,15),1729.41, "N"),
            new Installment(6, LocalDate.of(2024,8,15),1729.41, "N"),
            new Installment(7, LocalDate.of(2024,9,15),1729.41, "S"),
            new Installment(8, LocalDate.of(2024,10,15),1729.41, "S"),
            new Installment(9, LocalDate.of(2024,11,15),1729.41, "N"),
            new Installment(10, LocalDate.of(2024,12,15),1729.41, "N"),
            new Installment(11, LocalDate.of(2025,1,15),1729.41, "S"),
            new Installment(12, LocalDate.of(2025,2,15),1729.41, "N"),
            new Installment(13, LocalDate.of(2025,3,15),1729.41, "N"),
            new Installment(14, LocalDate.of(2025,4,15),1729.41, "N"),
            new Installment(15, LocalDate.of(2025,5,15),1729.41, "N"),
            new Installment(16, LocalDate.of(2025,6,15),1729.41, "N"),
            new Installment(17, LocalDate.of(2025,7,15),1729.41, "N"),
            new Installment(18, LocalDate.of(2025,8,15),1729.41, "S"),
            new Installment(19, LocalDate.of(2025,9,15),1729.41, "N"),
            new Installment(20, LocalDate.of(2025,10,15),1729.41, "N"),
            new Installment(21, LocalDate.of(2025,11,15),1729.41, "N"),
            new Installment(22, LocalDate.of(2025,12,15),1729.41, "N"),
            new Installment(23, LocalDate.of(2026,1,15),1729.41, "N"),
            new Installment(24, LocalDate.of(2026,2,15),1729.41, "N"),
            new Installment(25, LocalDate.of(2026,3,15),1729.41, "S"),
            new Installment(26, LocalDate.of(2026,4,15),1729.41, "S"),
            new Installment(27, LocalDate.of(2026,5,15),1729.41, "S"),
            new Installment(26, LocalDate.of(2026,6,15),1729.41, "N"),
            new Installment(29, LocalDate.of(2026,7,15),1729.41, "N"),
            new Installment(30, LocalDate.of(2026,8,15),1729.41, "N"),
            new Installment(31, LocalDate.of(2026,9,15),1729.41, "N"),
            new Installment(32, LocalDate.of(2026,10,15),1729.41, "S"),
            new Installment(33, LocalDate.of(2026,11,15),1729.41, "S"),
            new Installment(34, LocalDate.of(2026,12,15),1729.41, "N"),
            new Installment(35, LocalDate.of(2027,1,15),1729.41, "N"),
            new Installment(36, LocalDate.of(2027,2,15),1729.41, "S"),
            new Installment(37, LocalDate.of(2027,3,15),1729.41, "N"),
            new Installment(38, LocalDate.of(2027,4,15),1729.41, "N"),
            new Installment(39, LocalDate.of(2027,5,15),1729.41, "N"),
            new Installment(40, LocalDate.of(2027,6,15),1729.41, "N"),
            new Installment(41, LocalDate.of(2027,7,15),1729.41, "N"),
            new Installment(42, LocalDate.of(2027,8,15),1729.41, "N"),
            new Installment(43, LocalDate.of(2027,9,15),1729.41, "S"),
            new Installment(44, LocalDate.of(2027,10,15),1729.41, "N"),
            new Installment(45, LocalDate.of(2027,11,15),1729.41, "N"),
            new Installment(46, LocalDate.of(2027,12,15),1729.41, "N"),
            new Installment(47, LocalDate.of(2028,1,15),1729.41, "N"),
            new Installment(48, LocalDate.of(2028,2,15),1729.41, "N"),
            new Installment(49, LocalDate.of(2028,3,15),1729.41, "N"),
            new Installment(50, LocalDate.of(2028,4,15),1729.41, "S")
        )
    );

    public static void main(String [] args) {
//        List<Installment> myInstallments = initialization();
        LocalDate baseDate = LocalDate.of(2024,5,30);
//        attempt1(baseDate);
//        attempt2(baseDate);
//        attempt3(baseDate);
//        attempt4(baseDate);

        List<Installment> n = myInstallments.stream().filter(m -> m.getPaid().equals("N")).collect(Collectors.toList());
        //System.out.println(n);
        filtered(n);
    }

    private static void filtered(List<Installment> m/*, Predicate predicate*/) {

        List<Range> myRange = new ArrayList<>();
        searchForRange(m, myRange);

        Collection<IntSummaryStatistics> lista = new ArrayList<>();
        Map<Integer, IntSummaryStatistics> summarizedItems = new HashMap<>();

        extractListOfElements(myRange, summarizedItems);

        System.out.println("------");
        System.out.println(summarizedItems.values());
        System.out.println("------");

        /*
        myRange.stream()
                .collect(Collectors.groupingBy(Range::getId*//*, Collectors.summarizingDouble(myRange.stream().flatMap())*//*
                ));
        System.out.println(myRange);
        */
    }

    private static void extractListOfElements(List<Range> myRange, Map<Integer, IntSummaryStatistics> listOfElements) {
        Integer index = 1;
        for (Range r1 : myRange) {
            Map<String, IntSummaryStatistics> collect = r1.getInstallmentOfRange().stream()
                    .collect(Collectors.groupingBy(Installment::getPaid,
                            Collectors.summarizingInt(Installment::getNumber)));

            listOfElements.put(index, collect.get("N"));
            index++;
        }
    }

    private static void searchForRange(List<Installment> m, List<Range> myRange) {
        int i = m.get(0).getNumber();
        int id = 1;
        Range r = new Range(id);
        List<Installment> temp = new ArrayList<>();
        for (Installment e: m) {
            if (i+1>=e.getNumber()) {
                temp.add(e);
                i++;
            } else {
                r.setInstallmentOfRange(temp);
                temp=new ArrayList<>();
                temp.add(e);
                i=e.getNumber();
                myRange.add(r);
                id++;
                r= new Range(id);
            }
        }
        if (temp.size()>0) {
            r.setInstallmentOfRange(temp);
            myRange.add(r);
            temp=new ArrayList<>();
            temp=null;
        }
    }

    private static void attempt4(LocalDate baseDate) {
        Map<StatusPayment, Map<StatusDate, List<Installment>>> collect2 = myInstallments.stream()
                .collect(Collectors.groupingBy(i -> i.getPaid().equals("S") ? StatusPayment.PAYMENT_OK : StatusPayment.PAYMENT_PENDING,
                            Collectors.groupingBy(i -> i.getDueDate().isBefore(baseDate) ? StatusDate.OVERDUE : StatusDate.FUTURE)
                        )
                );

        System.out.println(collect2);
    }

    private static void attempt3(LocalDate baseDate) {
        Map<StatusDate, Map<StatusPayment, List<Installment>>> collect1 = myInstallments.stream()
//                .filter(i -> i.getNumber()>0)
//                .filter(i->i.getPaid().equals("N"))
                .collect(Collectors.groupingBy(
                        i -> i.getDueDate().isBefore(baseDate) ? StatusDate.OVERDUE : StatusDate.FUTURE,
                        Collectors.groupingBy(i -> i.getPaid().equals("S") ? StatusPayment.PAYMENT_OK : StatusPayment.PAYMENT_PENDING))
                );

        System.out.println(collect1);
    }

    private static void attempt2(LocalDate baseDate) {
        Map<StatusDate, List<Installment>> collect = myInstallments.stream()
//                .filter(i -> i.getNumber()>0)
                .filter(i->i.getPaid().equals("N"))
                .collect(Collectors.groupingBy(
                        i -> i.getDueDate().isBefore(baseDate) ? StatusDate.OVERDUE : StatusDate.FUTURE))
                ;

        System.out.println(collect);
    }

    private static void attempt1(LocalDate baseDate) {
        Map<StatusPayment, List<Installment>> s = myInstallments
                .stream()
                .filter(i->i.getPaid().equals("N"))
                .filter(i -> i.getDueDate().isBefore(baseDate))
                .collect(Collectors.groupingBy(i -> i.getPaid().equals("S") ? StatusPayment.PAYMENT_OK : StatusPayment.PAYMENT_PENDING));

        System.out.println(s);
    }

//    private static List<Installment> initialization() {
//        List<Installment> installments = new ArrayList<Installment>();
//
//        LocalDate refDate = LocalDate.of(2024, 2,15);
//        for (int i=0; i<=60; i++) {
//            Installment myInstallment = new Installment(i, refDate.plusMonths(i), 1729.41, i>0? "N" : "S");
//            installments.add(myInstallment);
//        }
//        System.out.println(installments);
//        return installments;
//    }

}
