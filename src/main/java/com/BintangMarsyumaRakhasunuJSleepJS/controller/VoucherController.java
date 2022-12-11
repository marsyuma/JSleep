package com.BintangMarsyumaRakhasunuJSleepJS.controller;

import com.BintangMarsyumaRakhasunuJSleepJS.Algorithm;
import com.BintangMarsyumaRakhasunuJSleepJS.Price;
import com.BintangMarsyumaRakhasunuJSleepJS.Voucher;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a controller for a voucher.
 * It provides methods create and update a voucher,
 *
 * @author Bintang MR
 *
 * @implements BasicGetController<Voucher>
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController{

    @JsonAutowired(value = Voucher.class, filepath = "C:\\Main\\Documents\\Kuliah\\Teknik Komputer\\SEMESTER 3\\Pemrograman Berbasis Objek\\Project\\JSleep\\src\\main\\java\\com\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    /**
     * Returns the table of voucher.
     *
     * @return the table of voucher
     */
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    /**
     * Determines whether the voucher with the specified ID has been used.
     *
     * @param id the ID of the voucher
     *
     * @return true if the voucher has been used, false otherwise
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @RequestParam int id
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }
    /**
     * Determines whether the voucher with the specified ID can be applied to the specified price.
     *
     * @param id the ID of the voucher
     * @param price the price to which the voucher should be applied
     *
     * @return true if the voucher can be applied, false otherwise
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(
            @RequestParam int id,
            @RequestParam double price
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }
    /**
     * Returns a paginated list of all available vouchers.
     *
     * @param page the page number to return
     * @param pageSize the number of items per page
     *
     * @return a paginated list of all available vouchers
     */
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        List<Voucher> collectVoucher = Algorithm.<Voucher>collect(getJsonTable(), pred -> true);
        List<Voucher> availableVoucher = new ArrayList<>();
        for(Voucher voucher : collectVoucher){
            if(!voucher.isUsed()){
                availableVoucher.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(availableVoucher, page, pageSize, pred -> true);
    }

}
