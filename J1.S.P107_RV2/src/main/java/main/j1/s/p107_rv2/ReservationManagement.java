package main.j1.s.p107_rv2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReservationManagement {
    private final List<Reservation> data = new ArrayList<>();

    private static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter DMY_HM_AMPM = DateTimeFormatter.ofPattern("d/M/yyyy h:mma");

    public int display() {
        System.out.println("*** Reservation Management *** ");
        System.out.println("1. Create new reservation");
        System.out.println("2. Update reservation");
        System.out.println("3. Delete reservation");
        System.out.println("4. Print Flight Information");
        System.out.println("5. Print all");
        System.out.println("6. Exit");
        System.out.print("You choose: ");
        return Validator.getIntInput();
    }

    public void run() {
        while (true) {
            int c = display();
            switch (c) {
                case 1 -> createReservation();
                case 2 -> updateReservation();
                case 3 -> deleteReservation();
                case 4 -> printFlightInfo();
                case 5 -> printAll();
                case 6 -> { System.out.println("BYE AND SEE YOU NEXT TIME"); return; }
                default -> System.out.println("Data input is  invalid");
            }
        }
    }

    private boolean idExists(String id) {
        return data.stream().anyMatch(r -> r.getBookingID().equals(id));
    }

    private Reservation findById(String id) {
        return data.stream().filter(r -> r.getBookingID().equals(id)).findFirst().orElse(null);
    }

    private String askId() {
        while (true) {
            String s = Validator.getStringInput("ID: ");
            if (!s.matches("\\d{6}")) { System.out.println("Data input is  invalid"); continue; }
            if (idExists(s)) { System.out.println("Data input is  invalid"); continue; }
            return s;
        }
    }

    private String askName() {
        while (true) {
            String s = Validator.getStringInput("Name: ");
            if (!s.matches("[A-Za-z ]+")) { System.out.println("Data input is  invalid"); continue; }
            return s;
        }
    }

    private String askPhone() {
        while (true) {
            String s = Validator.getStringInput("Phone: ");
            if (!s.matches("\\d{12}")) { System.out.println("Data input is  invalid"); continue; }
            return s;
        }
    }

    private String askRoom() {
        while (true) {
            String s = Validator.getStringInput("RoomNumbers: ");
            if (!s.matches("\\d{4}")) { System.out.println("Data input is  invalid"); continue; }
            return s;
        }
    }

    private LocalDate askBookingDate() {
        while (true) {
            String s = Validator.getStringInput("BookingDate: ");
            try {
                LocalDate d = LocalDate.parse(s, DMY);
                if (d.isAfter(LocalDate.now())) return d;
            } catch (DateTimeParseException ignore) {}
            System.out.println("Data input is  invalid");
        }
    }

    private LocalDateTime askTimePickUp(LocalDate bookingDate) {
        while (true) {
            String s = Validator.getStringInput("TimePickUp: ");
            try {
                LocalDateTime t = LocalDateTime.parse(s, DMY_HM_AMPM);
                if (t.isAfter(LocalDateTime.now()) && t.isBefore(bookingDate.atStartOfDay().plusDays(1))) return t;
            } catch (DateTimeParseException ignore) {}
            System.out.println("Data input is  invalid");
        }
    }

    private boolean askYesNo(String label) {
        while (true) {
            String s = Validator.getStringInput(label);
            if ("Y".equalsIgnoreCase(s)) return true;
            if ("N".equalsIgnoreCase(s)) return false;
            System.out.println("Data input is  invalid");
        }
    }

    private void createReservation() {
        System.out.println("*** Create new reservation *** ");
        String id = askId();
        String name = askName();
        String phone = askPhone();
        String room = askRoom();
        LocalDate booking = askBookingDate();

        FlightInformation fi = null;
        boolean need = askYesNo("Need airport pick up? (Y/N): ");
        if (need) {
            String flight = Validator.getStringInput("Flight: ");
            String seat = Validator.getStringInput("Seat: ");
            LocalDateTime tp = askTimePickUp(booking);
            fi = new FlightInformation(flight, seat, tp);
        }

        Reservation r = new Reservation(id, name, phone, room, booking, fi);
        data.add(r);
        System.out.println("Information saved successfully.");
    }

    private void updateReservation() {
        System.out.println("*** Update reservation *** ");
        String first = Validator.getStringInput("bookingID: ");
        Reservation r = findById(first);
        while (r == null) {
            System.out.println("ID: " + first);
            System.out.println("No information found");
            boolean again = askYesNo("You want to find again? (Y/N): ");
            if (!again) return;
            first = Validator.getStringInput("ID: ");
            r = findById(first);
        }

        printHeaderFull();
        printRowFull(r);
        System.out.println("If you do not want to change the information, just press enter to skip.");

        String name = Validator.getStringInput("Name: ");
        if (!name.isEmpty()) {
            if (!name.matches("[A-Za-z ]+")) System.out.println("Data input is  invalid");
            else r.setCustomerName(name);
        }

        String phone = Validator.getStringInput("Phone: ");
        if (!phone.isEmpty()) {
            if (!phone.matches("\\d{12}")) System.out.println("Data input is  invalid");
            else r.setPhoneNumber(phone);
        }

        String room = Validator.getStringInput("RoomNumbers: ");
        if (!room.isEmpty()) {
            if (!room.matches("\\d{4}")) System.out.println("Data input is  invalid");
            else r.setRoomNumber(room);
        }

        String bkd = Validator.getStringInput("BookingDate: ");
        if (!bkd.isEmpty()) {
            try {
                LocalDate d = LocalDate.parse(bkd, DMY);
                if (d.isAfter(LocalDate.now())) r.setBookingDate(d);
                else System.out.println("Data input is  invalid");
            } catch (DateTimeParseException e) {
                System.out.println("Data input is  invalid");
            }
        }

        String pick = Validator.getStringInput("Need airport pick up? (Y/N): ");
        if (!pick.isEmpty()) {
            if ("Y".equalsIgnoreCase(pick)) {
                if (r.getFlightInformation() == null) r.setFlightInformation(new FlightInformation());
                String flight = Validator.getStringInput("Flight: ");
                if (!flight.isEmpty()) r.getFlightInformation().setFlightNumber(flight);
                String seat = Validator.getStringInput("Seat: ");
                if (!seat.isEmpty()) r.getFlightInformation().setSeatNumber(seat);
                String tp = Validator.getStringInput("TimePickUp: ");
                if (!tp.isEmpty()) {
                    try {
                        LocalDateTime t = LocalDateTime.parse(tp, DMY_HM_AMPM);
                        if (t.isAfter(LocalDateTime.now()) && t.isBefore(r.getBookingDate().atStartOfDay().plusDays(1))) {
                            r.getFlightInformation().setTimePickUp(t);
                        } else {
                            System.out.println("Data input is  invalid");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Data input is  invalid");
                    }
                }
            } else if ("N".equalsIgnoreCase(pick)) {
                r.setFlightInformation(null);
            } else {
                System.out.println("Data input is  invalid");
            }
        }

        printHeaderFull();
        printRowFull(r);
        System.out.println("Information saved successfully.");
    }

    private void deleteReservation() {
        System.out.println("*** Delete reservation *** ");
        String id = Validator.getStringInput("ID: ");
        Reservation r = findById(id);
        while (r == null) {
            boolean again = askYesNo("You want to find again? (Y/N): ");
            if (!again) return;
            id = Validator.getStringInput("ID: ");
            r = findById(id);
        }
        printHeaderFull();
        printRowFull(r);
        boolean confirm = askYesNo("Are you sure you want to delete this information? (Y/N): ");
        if (confirm) {
            data.remove(r);
            System.out.println("Information deleted successfully.");
        }
    }

    private void printHeaderFull() {
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
    }

    private void printRowFull(Reservation r) {
        String flight = "";
        String seat = "";
        String time = "";
        if (r.getFlightInformation() != null) {
            flight = r.getFlightInformation().getFlightNumber();
            seat = r.getFlightInformation().getSeatNumber();
            time = r.getFlightInformation().getTimePickUp().format(DMY_HM_AMPM);
        }
        System.out.printf("%s - %s - %s - %s - %s - %s - %s - %s%n",
                r.getBookingID(),
                r.getCustomerName(),
                r.getPhoneNumber(),
                r.getRoomNumber(),
                r.getBookingDate().format(DMY),
                flight,
                seat,
                time);
    }

    private void printAll() {
        if (data.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("*** Reservation Information *** ");
        printHeaderFull();
        for (Reservation r : data) {
            printRowFull(r);
        }
    }

    private void printFlightInfo() {
        List<Reservation> list = new ArrayList<>();
        for (Reservation r : data) if (r.getFlightInformation() != null) list.add(r);
        if (list.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        list.sort(Comparator.comparing(o -> o.getFlightInformation().getTimePickUp()));
        System.out.println("*** Flight Information *** ");
        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        for (Reservation r : list) {
            FlightInformation fi = r.getFlightInformation();
            System.out.printf("%s - %s - %s - %s - %s - %s%n",
                    r.getBookingID(),
                    r.getCustomerName(),
                    r.getPhoneNumber(),
                    fi.getFlightNumber(),
                    fi.getSeatNumber(),
                    fi.getTimePickUp().format(DMY_HM_AMPM));
        }
    }
}
