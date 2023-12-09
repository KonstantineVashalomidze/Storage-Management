package org.example.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductScraper {


    public static List<String> extractLinksFromHtml() {
        List<String> hrefLinks = new ArrayList<>();
        String html = "<ul class=\"product-categories\"><li class=\"cat-item cat-item-305\"><a href=\"http://horoz.ge/category/%e1%83%90%e1%83%91%e1%83%90%e1%83%96%e1%83%90%e1%83%9c%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9b%e1%83%ac%e1%83%9d%e1%83%95%e1%83%98/\" previewlistener=\"true\">აბაზანის გამწოვები</a> <span class=\"count\">(6)</span></li>\n" +
                "<li class=\"cat-item cat-item-277\"><a href=\"http://horoz.ge/category/%e1%83%90%e1%83%95%e1%83%90%e1%83%a0%e1%83%98%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ავარიული სანათები</a> <span class=\"count\">(6)</span></li>\n" +
                "<li class=\"cat-item cat-item-307\"><a href=\"http://horoz.ge/category/%e1%83%90%e1%83%95%e1%83%a2%e1%83%9d%e1%83%9b%e1%83%90%e1%83%a2%e1%83%98%e1%83%a1-%e1%83%99%e1%83%90%e1%83%a0%e1%83%90%e1%83%93%e1%83%90/\" previewlistener=\"true\">ავტომატის კარადა</a> <span class=\"count\">(4)</span></li>\n" +
                "<li class=\"cat-item cat-item-299\"><a href=\"http://horoz.ge/category/%e1%83%99%e1%83%90%e1%83%91%e1%83%94%e1%83%9a%e1%83%98%e1%83%a1-%e1%83%a8%e1%83%94%e1%83%9b%e1%83%90%e1%83%94%e1%83%a0%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%9a%e1%83%98/\" previewlistener=\"true\">აქსესუარები</a> <span class=\"count\">(34)</span></li>\n" +
                "<li class=\"cat-item cat-item-173 cat-parent has-child\" aria-expanded=\"false\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">გარე განათებები</a> <span class=\"count\">(177)</span><button class=\"toggle\"><i class=\"icon-angle-down\"></i></button><ul class=\"children\">\n" +
                "<li class=\"cat-item cat-item-109 current-cat active\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%91%e1%83%90%e1%83%a6%e1%83%98%e1%83%a1-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ბაღის სანათები</a> <span class=\"count\">(45)</span></li>\n" +
                "<li class=\"cat-item cat-item-111\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%9e%e1%83%a0%e1%83%9d%e1%83%9f%e1%83%94%e1%83%a5%e1%83%a2%e1%83%9d%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">დიოდური პროჟექტორები</a> <span class=\"count\">(48)</span></li>\n" +
                "<li class=\"cat-item cat-item-265\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%99%e1%83%94%e1%83%93%e1%83%9a%e1%83%98%e1%83%a1-%e1%83%b0%e1%83%94%e1%83%a0%e1%83%9b%e1%83%94%e1%83%a2%e1%83%98%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94/\" previewlistener=\"true\">კედლის ჰერმეტიული სანათები</a> <span class=\"count\">(55)</span></li>\n" +
                "<li class=\"cat-item cat-item-110\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%a5%e1%83%a3%e1%83%a9%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%90/\" previewlistener=\"true\">ქუჩის განათება</a> <span class=\"count\">(12)</span></li>\n" +
                "<li class=\"cat-item cat-item-106\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%a0%e1%83%94-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%b0%e1%83%94%e1%83%a0%e1%83%9b%e1%83%94%e1%83%a2%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%91%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ჰერმეტული ბრები</a> <span class=\"count\">(29)</span></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li class=\"cat-item cat-item-175\"><a href=\"http://horoz.ge/category/%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%9a%e1%83%94%e1%83%9c%e1%83%a2%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">დიოდური ლენტები</a> <span class=\"count\">(4)</span></li>\n" +
                "<li class=\"cat-item cat-item-301\"><a href=\"http://horoz.ge/category/%e1%83%94%e1%83%9a-%e1%83%93%e1%83%90%e1%83%9b%e1%83%90%e1%83%92%e1%83%a0%e1%83%ab%e1%83%94%e1%83%9a%e1%83%94%e1%83%91%e1%83%9a%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ელ. დამაგრძელებლები</a> <span class=\"count\">(35)</span></li>\n" +
                "<li class=\"cat-item cat-item-303\"><a href=\"http://horoz.ge/category/%e1%83%94%e1%83%9a-%e1%83%a9%e1%83%90%e1%83%9c%e1%83%92%e1%83%90%e1%83%9a%e1%83%98/\" previewlistener=\"true\">ელ.ჩანგალი</a> <span class=\"count\">(9)</span></li>\n" +
                "<li class=\"cat-item cat-item-297\"><a href=\"http://horoz.ge/category/%e1%83%98%e1%83%96%e1%83%9d%e1%83%9a%e1%83%94%e1%83%9c%e1%83%a2%e1%83%90/\" previewlistener=\"true\">იზოლენტა</a> <span class=\"count\">(2)</span></li>\n" +
                "<li class=\"cat-item cat-item-285\"><a href=\"http://horoz.ge/category/%e1%83%99%e1%83%90%e1%83%a0%e1%83%98%e1%83%a1-%e1%83%96%e1%83%90%e1%83%a0%e1%83%98/\" previewlistener=\"true\">კარის ზარი</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-239\"><a href=\"http://horoz.ge/category/%e1%83%90%e1%83%95%e1%83%a2%e1%83%9d%e1%83%9b%e1%83%90%e1%83%a2%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%90%e1%83%9b%e1%83%9d%e1%83%9b%e1%83%a0%e1%83%97%e1%83%95%e1%83%94%e1%83%9a%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ლეგრანდი</a> <span class=\"count\">(16)</span></li>\n" +
                "<li class=\"cat-item cat-item-115 cat-parent has-child active\" aria-expanded=\"true\"><a href=\"http://horoz.ge/category/%e1%83%9b%e1%83%90%e1%83%92%e1%83%98%e1%83%93%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">მაგიდის განათებები</a> <span class=\"count\">(29)</span><button class=\"toggle\"><i class=\"icon-angle-down\"></i></button><ul class=\"children\">\n" +
                "<li class=\"cat-item cat-item-253\"><a href=\"http://horoz.ge/category/%e1%83%9b%e1%83%90%e1%83%92%e1%83%98%e1%83%93%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">განათებები</a> <span class=\"count\">(8)</span></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li class=\"cat-item cat-item-179 cat-parent has-child\" aria-expanded=\"false\"><a href=\"http://horoz.ge/category/%e1%83%9b%e1%83%96%e1%83%98%e1%83%a1-%e1%83%94%e1%83%9c%e1%83%94%e1%83%a0%e1%83%92%e1%83%98%e1%83%98%e1%83%a1-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">მზის ენერგიის სანათები</a> <span class=\"count\">(27)</span><button class=\"toggle\"><i class=\"icon-angle-down\"></i></button><ul class=\"children\">\n" +
                "<li class=\"cat-item cat-item-269\"><a href=\"http://horoz.ge/category/%e1%83%9b%e1%83%96%e1%83%98%e1%83%a1-%e1%83%94%e1%83%9c%e1%83%94%e1%83%a0%e1%83%92%e1%83%98%e1%83%98%e1%83%a1-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/%e1%83%9b%e1%83%96%e1%83%98%e1%83%a1-%e1%83%94%e1%83%9c%e1%83%94%e1%83%a0%e1%83%92%e1%83%98%e1%83%90%e1%83%96%e1%83%94-%e1%83%9b%e1%83%9d%e1%83%9b%e1%83%a3%e1%83%a8%e1%83%90%e1%83%95%e1%83%94/\" previewlistener=\"true\">მზის ენერგიაზე მომუშავე სანათები</a> <span class=\"count\">(26)</span></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li class=\"cat-item cat-item-84 cat-parent has-child\" aria-expanded=\"false\"><a href=\"http://horoz.ge/category/naturebi/\" previewlistener=\"true\">ნათურები</a> <span class=\"count\">(115)</span><button class=\"toggle\"><i class=\"icon-angle-down\"></i></button><ul class=\"children\">\n" +
                "<li class=\"cat-item cat-item-263\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%93%e1%83%94%e1%83%99%e1%83%9d%e1%83%a0%e1%83%90%e1%83%a2%e1%83%98%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">დეკორატიული ნათურები</a> <span class=\"count\">(16)</span></li>\n" +
                "<li class=\"cat-item cat-item-88\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%90/\" previewlistener=\"true\">დიოდური ნათურა</a> <span class=\"count\">(55)</span></li>\n" +
                "<li class=\"cat-item cat-item-86\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%93%e1%83%a6%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98%e1%83%a1-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%90/\" previewlistener=\"true\">დღის განათების ნათურა</a> <span class=\"count\">(11)</span></li>\n" +
                "<li class=\"cat-item cat-item-85\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%94%e1%83%99%e1%83%9d-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%90/\" previewlistener=\"true\">ეკო ნათურა</a> <span class=\"count\">(12)</span></li>\n" +
                "<li class=\"cat-item cat-item-91\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%a5%e1%83%a3%e1%83%a9%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98%e1%83%a1-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ქუჩის განათების ნათურები</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-87\"><a href=\"http://horoz.ge/category/naturebi/%e1%83%b0%e1%83%90%e1%83%9a%e1%83%9d%e1%83%92%e1%83%94%e1%83%9c%e1%83%98%e1%83%a1-%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%90/\" previewlistener=\"true\">ჰალოგენის ნათურა</a> <span class=\"count\">(11)</span></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li class=\"cat-item cat-item-293\"><a href=\"http://horoz.ge/category/%e1%83%9c%e1%83%90%e1%83%97%e1%83%a3%e1%83%a0%e1%83%98%e1%83%a1-%e1%83%aa%e1%83%9d%e1%83%99%e1%83%9d%e1%83%9a%e1%83%98/\" previewlistener=\"true\">ნათურის ცოკოლი</a> <span class=\"count\">(13)</span></li>\n" +
                "<li class=\"cat-item cat-item-350\"><a href=\"http://horoz.ge/category/%e1%83%a9%e1%83%90%e1%83%9b%e1%83%a0%e1%83%97%e1%83%95%e1%83%94%e1%83%9a%e1%83%94%e1%83%91%e1%83%98-%e1%83%a0%e1%83%9d%e1%83%96%e1%83%94%e1%83%a2%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ოვივო</a> <span class=\"count\">(43)</span></li>\n" +
                "<li class=\"cat-item cat-item-291\"><a href=\"http://horoz.ge/category/%e1%83%a0%e1%83%9d%e1%83%96%e1%83%94%e1%83%a2%e1%83%94%e1%83%91%e1%83%98-%e1%83%93%e1%83%90-%e1%83%a9%e1%83%90%e1%83%9b%e1%83%a0%e1%83%97%e1%83%95%e1%83%94%e1%83%9a%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">როზეტები და ჩამრთველები</a> <span class=\"count\">(95)</span></li>\n" +
                "<li class=\"cat-item cat-item-177\"><a href=\"http://horoz.ge/category/%e1%83%a1%e1%83%90%e1%83%a0%e1%83%99%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">სარკის განათებები</a> <span class=\"count\">(54)</span></li>\n" +
                "<li class=\"cat-item cat-item-283\"><a href=\"http://horoz.ge/category/%e1%83%a1%e1%83%94%e1%83%9c%e1%83%a1%e1%83%9d%e1%83%a0%e1%83%98/\" previewlistener=\"true\">სენსორი</a> <span class=\"count\">(20)</span></li>\n" +
                "<li class=\"cat-item cat-item-295\"><a href=\"http://horoz.ge/category/%e1%83%a1%e1%83%a2%e1%83%90%e1%83%a0%e1%83%a2%e1%83%94%e1%83%a0%e1%83%98/\" previewlistener=\"true\">სტარტერი</a> <span class=\"count\">(2)</span></li>\n" +
                "<li class=\"cat-item cat-item-289\"><a href=\"http://horoz.ge/category/%e1%83%a2%e1%83%90%e1%83%98%e1%83%9b%e1%83%94%e1%83%a0%e1%83%98/\" previewlistener=\"true\">ტაიმერი</a> <span class=\"count\">(2)</span></li>\n" +
                "<li class=\"cat-item cat-item-273\"><a href=\"http://horoz.ge/category/%e1%83%a2%e1%83%a0%e1%83%90%e1%83%9c%e1%83%a1%e1%83%a4%e1%83%9d%e1%83%a0%e1%83%9b%e1%83%90%e1%83%a2%e1%83%9d%e1%83%a0%e1%83%98/\" previewlistener=\"true\">ტრანსფორმატორი</a> <span class=\"count\">(19)</span></li>\n" +
                "<li class=\"cat-item cat-item-275\"><a href=\"http://horoz.ge/category/%e1%83%a4%e1%83%90%e1%83%9c%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ფანრები</a> <span class=\"count\">(13)</span></li>\n" +
                "<li class=\"cat-item cat-item-281\"><a href=\"http://horoz.ge/category/%e1%83%a4%e1%83%9d%e1%83%a2%e1%83%9d%e1%83%a0%e1%83%94%e1%83%9a%e1%83%94%e1%83%94%e1%83%91%e1%83%98-ka/\" previewlistener=\"true\">ფოტორელეები</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-92 cat-parent has-child\" aria-expanded=\"false\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">შიდა განათებები</a> <span class=\"count\">(334)</span><button class=\"toggle\"><i class=\"icon-angle-down\"></i></button><ul class=\"children\">\n" +
                "<li class=\"cat-item cat-item-95\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%91%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ბრები</a> <span class=\"count\">(66)</span></li>\n" +
                "<li class=\"cat-item cat-item-255\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%93%e1%83%94%e1%83%99%e1%83%9d%e1%83%a0%e1%83%90%e1%83%a2%e1%83%98%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%9e%e1%83%90%e1%83%a2%e1%83%a0%e1%83%9d%e1%83%9c%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">დეკორატიული პატრონები</a> <span class=\"count\">(5)</span></li>\n" +
                "<li class=\"cat-item cat-item-99\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98%e1%83%a1-%e1%83%91%e1%83%a3%e1%83%93%e1%83%94%e1%83%94%e1%83%91/\" previewlistener=\"true\">დიოდური განათების ბუდეები</a> <span class=\"count\">(14)</span></li>\n" +
                "<li class=\"cat-item cat-item-271\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%9a%e1%83%94%e1%83%9c%e1%83%a2%e1%83%94%e1%83%91%e1%83%98-ka/\" previewlistener=\"true\">დიოდური ლენტები</a> <span class=\"count\">(19)</span></li>\n" +
                "<li class=\"cat-item cat-item-100\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%99%e1%83%94%e1%83%93%e1%83%9a%e1%83%98%e1%83%a1-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98%e1%83%a1-%e1%83%91%e1%83%a3%e1%83%93%e1%83%94%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">კედლის განათების ბუდეები</a> <span class=\"count\">(10)</span></li>\n" +
                "<li class=\"cat-item cat-item-102\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%9b%e1%83%9d%e1%83%ab%e1%83%a0%e1%83%90%e1%83%95%e1%83%98-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">მოძრავი განათებები</a> <span class=\"count\">(30)</span></li>\n" +
                "<li class=\"cat-item cat-item-259\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%a1%e1%83%90%e1%83%a0%e1%83%99%e1%83%98%e1%83%a1-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">სარკის სანათები</a> <span class=\"count\">(53)</span></li>\n" +
                "<li class=\"cat-item cat-item-257\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%a1%e1%83%94%e1%83%9c%e1%83%a1%e1%83%9d%e1%83%a0%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%91%e1%83%a0%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">სენსორული ბრები</a> <span class=\"count\">(8)</span></li>\n" +
                "<li class=\"cat-item cat-item-261\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%a2%e1%83%9d%e1%83%a0%e1%83%a8%e1%83%94%e1%83%a0%e1%83%98/\" previewlistener=\"true\">ტორშერი</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-97\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%a8%e1%83%94%e1%83%99%e1%83%98%e1%83%93%e1%83%a3%e1%83%9a%e1%83%98-%e1%83%ad%e1%83%94%e1%83%a0%e1%83%98%e1%83%a1-%e1%83%91%e1%83%a3%e1%83%93%e1%83%94%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">შეკიდული ჭერის ბუდეები</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-233\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%ac%e1%83%94%e1%83%a0%e1%83%a2%e1%83%98%e1%83%9a%e1%83%9d%e1%83%95%e1%83%90%e1%83%9c%e1%83%98-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">წერტილოვანი განათებები</a> <span class=\"count\">(90)</span></li>\n" +
                "<li class=\"cat-item cat-item-249\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%ad%e1%83%90%e1%83%a6%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ჭაღები</a> <span class=\"count\">(12)</span></li>\n" +
                "<li class=\"cat-item cat-item-96\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%ad%e1%83%94%e1%83%a0%e1%83%98%e1%83%a1-%e1%83%93%e1%83%90-%e1%83%99%e1%83%94%e1%83%93%e1%83%9a%e1%83%98%e1%83%a1-%e1%83%93%e1%83%98%e1%83%9d%e1%83%93%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%a1/\" previewlistener=\"true\">ჭერის და კედლის დიოდური სანათები</a> <span class=\"count\">(67)</span></li>\n" +
                "<li class=\"cat-item cat-item-94\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%98%e1%83%93%e1%83%90-%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%94%e1%83%91%e1%83%98/%e1%83%ad%e1%83%94%e1%83%a0%e1%83%98%e1%83%a1-%e1%83%93%e1%83%90-%e1%83%99%e1%83%94%e1%83%93%e1%83%9a%e1%83%98%e1%83%a1-%e1%83%a1%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%98/\" previewlistener=\"true\">ჭერის და კედლის სანათები</a> <span class=\"count\">(21)</span></li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "<li class=\"cat-item cat-item-267\"><a href=\"http://horoz.ge/category/%e1%83%a8%e1%83%a2%e1%83%90%e1%83%a2%e1%83%98%e1%83%95%e1%83%98/\" previewlistener=\"true\">შტატივი</a> <span class=\"count\">(3)</span></li>\n" +
                "<li class=\"cat-item cat-item-352\"><a href=\"http://horoz.ge/category/%e1%83%ad%e1%83%90%e1%83%a6%e1%83%94%e1%83%91%e1%83%98-ka/\" previewlistener=\"true\">ჭაღები</a> <span class=\"count\">(61)</span></li>\n" +
                "<li class=\"cat-item cat-item-251\"><a href=\"http://horoz.ge/category/%e1%83%92%e1%83%90%e1%83%9c%e1%83%90%e1%83%97%e1%83%94%e1%83%91%e1%83%90/\" previewlistener=\"true\">ჭერში ჩასასმელი განათებები</a> <span class=\"count\">(71)</span></li>\n" +
                "<li class=\"cat-item cat-item-15\"><a href=\"http://horoz.ge/category/%e1%83%b0%e1%83%9d%e1%83%a0%e1%83%9d%e1%83%96%e1%83%98/\" previewlistener=\"true\">ჰოროზი</a> <span class=\"count\">(142)</span></li>\n" +
                "<li class=\"cat-item cat-item-241\"><a href=\"http://horoz.ge/category/%e1%83%90%e1%83%95%e1%83%a2%e1%83%9d%e1%83%9b%e1%83%90%e1%83%a2%e1%83%a3%e1%83%a0%e1%83%98-%e1%83%90%e1%83%9b%e1%83%9d%e1%83%9b%e1%83%a0%e1%83%97%e1%83%95%e1%83%94%e1%83%9a%e1%83%98/\" previewlistener=\"true\">ჰოროზის ავტომატური ამომრთველი</a> <span class=\"count\">(37)</span></li>\n" +
                "</ul>"; // Paste the HTML content here
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String href = link.attr("href");
            hrefLinks.add(href);
        }
        return hrefLinks;
    }




    public static void main(String[] args) {

        List<String> hrefLinks = extractLinksFromHtml();
        for (String link : hrefLinks) {
            try {
                // Fetch the HTML content from the URL
                Document doc = Jsoup.connect(link).get();

                // Extract the type from the URL
                String urlString = doc.baseUri();
                String decodedURL = URLDecoder.decode(urlString, "UTF-8");
                String type = extractTypeFromURL(decodedURL);

                // Select all product cards using the given XPath
                Elements productCards = doc.select(".product-small.box");

                // Create a StringBuilder to store data
                StringBuilder data = new StringBuilder();

                // Loop through each product card and extract necessary data
                for (Element productCard : productCards) {

                    // Extract image URL
                    String imageURL = productCard.select(".box-image img").attr("src");

                    // Extract product name and category
                    String productName = productCard.select(".name.product-title a").text();
                    String category = productCard.select(".category.product-cat").text();

                    // Extract price
                    String price = productCard.select(".price .woocommerce-Price-amount").text();

                    // Append data to the StringBuilder with type included
                    data.append(type).append(" | ");
                    data.append(productName).append(" | ");
                    data.append(category).append(" | ");
                    data.append(price).append(" | ");
                    data.append(imageURL).append("\n");
                }

                // Write data to a text file in append mode
                BufferedWriter writer = new BufferedWriter(new FileWriter("product_data.txt", true));
                writer.write(data.toString());
                writer.close();

                System.out.println("Data appended to ProductData.txt successfully.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    // Method to extract type from the URL
    private static String extractTypeFromURL(String url) {
        Pattern pattern = Pattern.compile("/category/([^/]+)/.*$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "defaultType"; // Return a default type if not found
    }

}
