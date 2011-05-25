package falcons.plugin.exported.wolPlugin;

import java.net.InetAddress;

import falcons.plugin.Pluggable;

public class Client implements Pluggable {
	private InetAddress ip;
	private byte[] mac;
	
	public Client() {
		// Do nasing...
	}
	
	public Client(String ipStr, String macStr) {
		try {
            byte[] macBytes = getMacBytes(macStr);
            mac = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                mac[i] = (byte) 0xff;
            }
            for (int i = 6; i < mac.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, mac, i, macBytes.length);
            }
            
            ip = InetAddress.getByName(ipStr);
        }
        catch (Exception e) {
            System.out.println("Invalid address information:" + e);
        }
        
    }
    
    private byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = macStr.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }
    
    public byte[] getMac() {
    	return mac.clone();
    }
    
    public InetAddress getIp() {
    	return ip;
    }
}
