package uri.elpuig.projectefx;

public class PublicIP {

    public String ip,country,city;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PublicIP\n" +
                "ip='" + ip + '\n' +
                "country='" + country + '\n' +
                "city='" + city ;
    }
}
