package com.med.market.fo.action;

import java.io.File;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.med.market.bll.service.CommonService;
import com.med.market.bll.service.ProductService;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.service.MailService;
import com.med.market.util.ConfigurationManager;
import com.med.market.util.CrossSellProduct;
import com.med.market.util.ProductUtil;

public class ProductAction extends AbstractAction {
	private static final int NUMBER_OF_SIMILAR = 10;
    private ProductService productService;
    private CommonService commonService;
    private MailService mailService;
    private List<Image> images;
    private List<CrossSellProduct> similar;
    private Product product;
    private boolean update = true;
    private String productId;
    private String url;
    private String name;
    private String password;
    private String description;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactAddress;
    private String price;
    private String catId;
    private String provinceId;
    private String uploadedImages = "";
    private int msgId = 0;
    private File fileToUpload;
    private String fileToUploadContentType;
    private String fileToUploadFileName;
    private List<Province> provinces;
    private List<Category> categories;
    private LinkedHashMap<String, Object> jsonData = new LinkedHashMap<String, Object>();

    public String addProduct() throws Exception {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }

    public String postProduct() throws Exception {
    	Product product;
    	if (productId != null && !"".equals(productId)) {
    		product = productService.get(new Long(productId));
    		msgId = ProductUtil.UPDATE_SUCCESS;
    	} else {
    		product = new Product();
    		product.setPassword(password);
    		msgId = ProductUtil.ADD_SUCCESS;
    	}
        product.setName(name);
        product.setDescription(description);
        if (price != null && !"".equals(price)) {
        	product.setPrice(Long.parseLong(price));
        } else {
        	product.setPrice(new Long(0));
        }
        product.setContactName(contactName);
        product.setContactEmail(contactEmail);
        product.setContactPhone(contactPhone);
        product.setContactAddress(contactAddress);
        productService.txAdd(product, new Long(catId), new Long(provinceId), uploadedImages);
        
        return "success";
    }
    
    public String productUpdateSubmit() throws Exception {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }
    
    public String productSuccess() throws Exception {
    	return "success";
    }
    
    public String updateProduct() throws Exception {
    	return "success";
    }
    
    public String productLogin() throws Exception {
    	Product product = productService.get(new Long(productId));
    	if (product != null) {
	    	if (password != null && !"".equals(password)) {
	    		if (product.getPassword().equals(password)) {
	    			if (update) {
	    				updateProductInfo(product);
	    				return "update";
	    			} else {
	    				productService.delete(product);
	    				msgId = ProductUtil.DEL_SUCCESS;
	    				return "delete";
	    			}
	    		} else {
	    			addActionMessage("Mật khẩu không chính xác");
	    			return "input";
	    		}
	    	} else {
	    		if (contactEmail.equals(product.getContactEmail())) {
		    		msgId = ProductUtil.SENT_EMAIL;
		    		sendPasswordEmail(product);
		    		return "email";
	    		} else {
	    			addActionMessage("Không phải email đã dùng để đăng sản phẩm");
	    			return "input";
	    		}
	    	}
    	}
    	addActionMessage("Sản phẩm không tồn tại");
    	return "error";
    }

    private void sendPasswordEmail(Product product) throws Exception {
    	String subject = "Cấp lại mật khẩu cho sản phẩm: " + product.getName();
    	String domain = ConfigurationManager.getAsString("sitedomain");
    	String msg = "";
		msg += "\r\nBạn đã yêu cầu cấp lại mật khẩu cho sản phẩm: " + product.getName();
		msg += "\r\nMật khẩu là: " + product.getPassword();
		msg += "\r\nVui lòng sử dụng mật khẩu này để cập nhật/xóa sản phẩm tại: " + domain + "/" + product.getFriendlyUrl();
		msg += "\r\n\r\n Xin cảm ơn,";
    	mailService.sendMail(product.getContactEmail(), subject, msg);
    }
    
	private void updateProductInfo(Product product) {
		name = product.getName();
		description = product.getDescription();
		contactName = product.getContactName();
		contactEmail = product.getContactEmail();
		contactAddress = product.getContactAddress();
		contactPhone = product.getContactPhone();
		price = product.getPrice() + "";
		catId = product.getCategory().getCatId() + "";
		provinceId = product.getProvince().getProvinceId() + "";
		List<Image> images = commonService.getImagesByProductId(new Long(productId));
		for (Image image : images) {
			if (image != null && image.getUrl() != null && !"".equals(image.getUrl())) {
				uploadedImages += getImageName(image.getUrl()) + ",";
			}
		}
		
		provinces = commonService.getAllProvince();
		categories = commonService.getAllCategories();
	}
    
    public String updatePost() throws Exception {
    	msgId = ProductUtil.UPDATE_SUCCESS;
    	return "success";
    }
    
    public String ajaxUploadImg() throws Exception {
    	String filePath = ConfigurationManager.getAsString("fileupload.path");
        String fileName = generateFileName(fileToUploadFileName);
        File fileToCreate = new File(filePath, fileName);
        FileUtils.copyFile(fileToUpload, fileToCreate);
    	jsonData.put("url", fileToCreate.getName());
    	return "success";
    }

    public String viewDetail() throws Exception {
    	product = productService.getByUrl(url);
    	if (product != null) {
    		images = commonService.getImagesByProductId(product.getProductId());
    	} else {
    		return "error";
    	}
    	similar = productService.findSimilar(product.getProductId(), product.getCategory().getCatId(), NUMBER_OF_SIMILAR);
    	return "success";
    }
    
    private String getImageName(String url) {
    	int idx = url.lastIndexOf("/");
    	return url.substring(idx + 1, url.length());
    }
    
    private String generateFileName(String fileName) {
    	long time = Calendar.getInstance().getTimeInMillis();
    	if (fileName == null) {
    		return time + "";
    	}
    	fileName = fileName.replaceAll("\\s", "");
        if (fileName.length() > 10) {
        	fileName = fileName.substring(fileName.length() - 10, fileName.length());
        }
        return time + "_" + fileName;
    }

    public ProductService getProductService() {
        return productService;
    }

    public List<Image> getImages() {
		return images;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public File getFileToUpload() {
		return fileToUpload;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public List<CrossSellProduct> getSimilar() {
		return similar;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setSimilar(List<CrossSellProduct> similar) {
		this.similar = similar;
	}

	public void setFileToUpload(File fileToUpload) {
		this.fileToUpload = fileToUpload;
	}

	public String getUrl() {
		return url;
	}

	public Product getProduct() {
		return product;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LinkedHashMap<String, Object> getJsonData() {
		return jsonData;
	}

	public String getFileToUploadContentType() {
		return fileToUploadContentType;
	}

	public void setFileToUploadContentType(String fileToUploadContentType) {
		this.fileToUploadContentType = fileToUploadContentType;
	}

	public String getFileToUploadFileName() {
		return fileToUploadFileName;
	}

	public void setFileToUploadFileName(String fileToUploadFileName) {
		this.fileToUploadFileName = fileToUploadFileName;
	}

	public void setJsonData(LinkedHashMap<String, Object> jsonData) {
		this.jsonData = jsonData;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUploadedImages() {
        return uploadedImages;
    }

    public void setUploadedImages(String uploadedImages) {
        this.uploadedImages = uploadedImages;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
