package org.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class InputView {
    private Scanner sc;
    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public Menu inputMenu() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 번호 조회, 4. 전체 할 일 목록 (7일이내),5.검색, 6.종료");
        return Menu.get(Integer.parseInt(sc.nextLine()));
    }

    public int inputDeleteById() {
        System.out.println("삭제할 번호를 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public int inputFindById() {
        System.out.println("검색할 번호를 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public String inputSearchContent() {
        System.out.println("검색어를 입력해주세요");
        return sc.nextLine();
    }

    public String inputContent() {
        System.out.println("할일을 적어주세요. ");
        return sc.nextLine();
    }

    public LocalDate  inputDate() throws ParseException {
        System.out.println("마감일을 입력해주세요 ex) YYYYMMDD");
        String endDateStr = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(endDateStr, formatter);
    }
}
