/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.be;

/**
 *
 * @author Frederik Bærbar
 */
public class Category
{

    private int CategoryId;

    private String CatergoryName;

    public Category(int CategoryId, String CatergoryName)
    {
        this.CategoryId = CategoryId;
        this.CatergoryName = CatergoryName;
    }

    /**
     * Get the value of CatergoryName
     *
     * @return the value of CatergoryName
     */
    public String getCatergoryName()
    {
        return CatergoryName;
    }

    /**
     * Set the value of CatergoryName
     *
     * @param CatergoryName new value of CatergoryName
     */
    public void setCatergoryName(String CatergoryName)
    {
        this.CatergoryName = CatergoryName;
    }

    /**
     * Get the value of CategoryId
     *
     * @return the value of CategoryId
     */
    public int getCategoryId()
    {
        return CategoryId;
    }

    /**
     * Set the value of CategoryId
     *
     * @param CategoryId new value of CategoryId
     */
    public void setCategoryId(int CategoryId)
    {
        this.CategoryId = CategoryId;
    }

    @Override
    public String toString()
    {
        return CatergoryName;
    }

}
