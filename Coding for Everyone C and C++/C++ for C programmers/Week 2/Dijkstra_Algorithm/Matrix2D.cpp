#include <iostream>
#include <vector>

template <typename T>
class  Matrix2D
{
    std::vector<T> data;
    unsigned int sizeX, sizeY;

    public:
    Matrix2D(unsigned int x, unsigned int y) : sizeX(x), sizeY(y){
        // std::cout << "Starting with : "<< x << ", " << y << std::endl;
        data.resize (sizeX*sizeY);
    }

    void print(){
        // std::cout << "Printing a matrix the size of: " << sizeX << ", " << sizeY << std::endl;
        for (unsigned int i = 0; i < sizeY * sizeX; i++){
            std::cout << data[i] << "\t";
            if ((i + 1) % sizeX == 0){
                std::cout << std::endl;
            }
        }
    }

    T& operator()(unsigned int x, unsigned int y){
        if (x >= sizeX || y >= sizeY){
            throw std::out_of_range("x or y out of range");
        }
        return data[sizeX * y + x];
    }
};