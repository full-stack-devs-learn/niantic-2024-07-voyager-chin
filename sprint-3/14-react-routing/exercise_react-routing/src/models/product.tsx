export class Product
{
    productId!: number;
    productName!: string;
    supplierId!: number;
    categoryId!: number;
    quantityPerUnit!: string;
    unitPrice!: number;
    unitsInStock!: number;
    unitsOnOrder!: number;
    reorderLevel!: number;
    discontinued!: boolean;
}