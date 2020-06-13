package list.recycleview.model;

import java.util.ArrayList;

import list.recycleview.model.Mobo;

public class MoboData {
    public static String[][] data = new String[][]{
            {"ROG STRIX B450-F GAMING", "ROG Strix B450 Gaming series provides a feature set distilled" +
                    "from the high-end ROG Strix X470 Gaming series that gives you all the essentials" +
                    "for a well-balanced build. With comprehensive cooling options, dual PCIe 3.0 M.2" +
                    "slots and AMD StoreMI support for incredible storage speeds, improved DDR4 memory" +
                    "stability and much more, ROG Strix B450 Gaming delivers the performance you need" +
                    "with room to focus your budget on accompanying hardware. The motherboard also " +
                    "offers rich", "https://www.asus.com/media/global/products/BcBedDgYvyES4nkc/P_setting_000_1_90_end_500.png", "$171.91"},
            {"MSI B450-A PRO ", "MAKING YOUR LIFE EASIER IS OUR BUSINESS " +
                    "Combining quality you can rely on with top performance and clever business solutions " +
                    "are key aspects of the MSI PRO SERIES motherboards. Engineered to gratify even " +
                    "the most demanding professional, these motherboards will fit in any PC. Making " +
                    "your life easier and supporting your business with super stable, reliable and " +
                    "long-lasting top performance.", "https://asset.msi.com/resize/image/global/product/product_3_20190506092649_5ccf8d5972c9c.png62405b38c58fe0f07fcef2367d8a9ba1/1024.png", "$111.07"},
            {"Asus ROG Crosshair VI Hero","For more than a decade, Republic of Gamers has delivered " +
                    "exemplary design and performance to thrill the world's best players and PC enthusiasts. " +
                    "Our journey is a road without end. Now, it's time for competitors to be warned " +
                    "and for gamers and enthusiasts to push the limits: The packed and pumped ROG " +
                    "Crosshair VI Hero Series motherboard is ready to defeat all challengers.","https://www.asus.com/media/global/products/ghtVfXqMRP7gHFkj/P_setting_000_1_90_end_500.png","$220.97"},
            {"MSI B450 TOMHAWK", "BUILT ON EVERLASTING QUALITY Using only the finest quality " +
                    "components and integrating the latest technological innovations delivers the best " +
                    "possible gaming and professional experience. Rigorous quality testing under the" +
                    "most extreme conditions ensures a super reliable, high performance motherboard.", "https://images-na.ssl-images-amazon.com/images/I/91PepCpcv5L._SX679_.jpg", "$139.27"},
            {"ASRock B450 Steel Legend", "Steel Legend represents the philosophical state of rock-solid" +
                    " durability and irresistible aesthetics. Built around most demanding specs and " +
                    "features, the Steel Legend series aims at daily users and mainstream enthusiasts! " +
                    "Providing a strong array of materials/components to ensure a stable and reliable " +
                    "performance. A motherboard that fulfills every task – with style!", "https://ecs7.tokopedia.net/img/cache/700/product-1/2019/3/14/1600332/1600332_692ba684-ff81-4047-ba39-655ba53f0959_583_583.jpg", "$110.44"},
            {"AORUS B450 PRO", "The AORUS Core is inspired by the falcon's aggressive nature and hunting" +
                    " prowess. The falcon uses its razor sharp talons to swiftly strike down its prey " +
                    "with exceptional efficiency and precision, qualities that are exemplified in the " +
                    "fine details of AORUS design.", "https://cdn.alzashop.com/ImgW.ashx?fd=f3&cd=AG450a1", "166.71"},
            {"ASRock Z390 Phantom Gaming 6", "The intelligent Phantom Gaming 2.5Gb/s LAN platform is" +
                    " built for maximum networking performance for the demanding requirements of home " +
                    "networking, content creators, online gamers and high-quality streaming media. " +
                    "Boost networking performance up to 2.5X the bandwidth compared to the standard " +
                    "gigabit Ethernet, you’ll enjoy the faster and uncompromised connectivity experience " +
                    "for gaming, file transfers and backups.", "https://images10.newegg.com/BizIntell/item/13/157/13-157-850/1_101118.jpg", "$206.85"},
            {"MSI B450M MORTAR TITANIUM", "A GAMERS' BIOS We made sure our BIOS contains all the latest " +
                    "options and is easy to use for everyone. The extensive features let you fine-tune " +
                    "your system to deliver reliable maximum performance when gaming.", "https://s0.bukalapak.com/img/5682393113/w-1000/MSI_B450M_MORTAR_TITANIUM_AMD_B450_AM4_DDR4_Micro_ATX_Mother.jpg", "$147.65"},
            {"TUF B450-PLUS GAMING", "TUF Gaming motherboards are specially designed and tested to " +
                    "survive and thrive in conditions where other boards would struggle. Engineered " +
                    "with highly durable components, these motherboards deliver unwavering stability " +
                    "for gaming sessions that last as long as you demand.", "https://www.asus.com/media/global/products/no5yeNpeGG0mDKX1/P_setting_000_1_90_end_500.png", "$113.95"},
            {"ROG Strix X470-F","ROG Strix X470-FROG Strix X470-F Gaming is the perfect fusion of " +
                    "performance and panache. It's an ATX motherboard packed with easy-to-use tuning " +
                    "tech and understated aesthetics for those who demand great gaming experiences " +
                    "and refined style. Strix X470-F Gaming keeps the pedal down on performance, and " +
                    "its rich customization options let you push your rig from subtle to standout in " +
                    "seconds.\n","https://www.quietpc.com/images/products/asus-x470-f-gaming-box-large.jpg","$287.48"}
    };

    public static ArrayList<Mobo> getListData() {
        ArrayList<Mobo> list = new ArrayList<>();
        for (String[] aData : data) {
            Mobo mobo = new Mobo();
            mobo.setName(aData[0]);
            mobo.setFrom(aData[1]);
            mobo.setPhoto(aData[2]);
            mobo.setHarga(aData[3]);

            list.add(mobo);
        }
        return list;
    }
}
