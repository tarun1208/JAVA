import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = sc.nextInt();

        System.out.print("Enter output rate: ");
        int outputRate = sc.nextInt();

        System.out.print("Enter number of time intervals: ");
        int n = sc.nextInt();

        int[] inputPackets = new int[n];
        System.out.println("Enter number of packets arriving at each interval:");
        for (int i = 0; i < n; i++) {
            inputPackets[i] = sc.nextInt();
        }

        int currentBucket = 0;

        System.out.println();
        System.out.printf("%-5s %-17s %-13s %-13s %-15s%n",
                "Time", "Packets Incoming", "Packets Sent", "Packets Left", "Packets Dropped");

        for (int i = 0; i < n; i++) {
            int incoming = inputPackets[i];
            int dropped = 0;

            if (incoming + currentBucket > bucketCapacity) {
                dropped = (incoming + currentBucket) - bucketCapacity;
                currentBucket = bucketCapacity;
            } else {
                currentBucket += incoming;
            }

            int sent = Math.min(outputRate, currentBucket);
            int left = currentBucket - sent;


            currentBucket = left;

            System.out.printf("%-5d %-17d %-13d %-13d %-15d%n",
                    i + 1, incoming, sent, left, dropped);
        }

        sc.close();
    }
}
