package zhh.ap.bean;

public class StaticDataType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sd_h_type.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sd_h_type.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sd_h_type.parent
     *
     * @mbggenerated
     */
    private Integer parent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sd_h_type.id
     *
     * @return the value of sd_h_type.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sd_h_type.id
     *
     * @param id the value for sd_h_type.id
     *
     * @mbggenerated
     */
    private void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sd_h_type.name
     *
     * @return the value of sd_h_type.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sd_h_type.name
     *
     * @param name the value for sd_h_type.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sd_h_type.parent
     *
     * @return the value of sd_h_type.parent
     *
     * @mbggenerated
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sd_h_type.parent
     *
     * @param parent the value for sd_h_type.parent
     *
     * @mbggenerated
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }
}