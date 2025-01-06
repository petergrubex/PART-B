public class NextAIInc {

    private static final int MIN_HOURLY_RATE = 30000;
    private static final int REGULAR_HOURS_LIMIT = 48;
    private static final int MAX_HOURS_LIMIT = 72;
    
    public void calculateWeeklyPay(int baseHourlyRate, int hoursWorked) {
        
        if (baseHourlyRate < MIN_HOURLY_RATE) {
            System.out.println("Error: Base pay rate of UGX " + baseHourlyRate + 
                             " is below the minimum required rate of UGX " + MIN_HOURLY_RATE);
            return;
        }
        
        if (hoursWorked > MAX_HOURS_LIMIT) {
            System.out.println("Error: Hours worked (" + hoursWorked + 
                             ") exceeds the maximum allowed limit of " + MAX_HOURS_LIMIT + " hours");
            return;
        }
        
        int regularHours = Math.min(hoursWorked, REGULAR_HOURS_LIMIT);
        int overtimeHours = Math.max(0, hoursWorked - REGULAR_HOURS_LIMIT);
        
        long regularPay = (long) regularHours * baseHourlyRate;
        long overtimePay = (long) overtimeHours * (baseHourlyRate * 2);
        long totalPay = regularPay + overtimePay;
        
        System.out.println("\nPayment Breakdown:");
        System.out.println("Base Hourly Rate: UGX " + baseHourlyRate);
        System.out.println("Regular Hours: " + regularHours + " @ UGX " + baseHourlyRate + 
                          " = UGX " + regularPay);
        if (overtimeHours > 0) {
            System.out.println("Overtime Hours: " + overtimeHours + " @ UGX " + 
                             (baseHourlyRate * 2) + " = UGX " + overtimePay);
        }
        System.out.println("Total Pay: UGX " + totalPay);
    }
    
    public static void main(String[] args) {
        NextAIInc paymentCalculator = new NextAIInc();
        
        System.out.println("Test Case A:");
        paymentCalculator.calculateWeeklyPay(30000, 51);
        
        System.out.println("\nTest Case B:");
        paymentCalculator.calculateWeeklyPay(20000, 40);
        
        System.out.println("\nTest Case C:");
        paymentCalculator.calculateWeeklyPay(35000, 96);
    }
}