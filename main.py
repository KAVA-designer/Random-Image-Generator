import random
import subprocess

def generate_random_parameters():
    width = random.randint(100, 1000)
    height = random.randint(100, 1000)
    red = random.randint(0, 255)
    green = random.randint(0, 255)
    blue = random.randint(0, 255)
    return width, height, red, green, blue

def generate_image():
    width, height, red, green, blue = generate_random_parameters()
    cmd = ["java", "ImageGenerator", str(width), str(height), str(red), str(green), str(blue)]
    
    try:
        subprocess.run(cmd, check=True)
        print("Image generated successfully!")
    except subprocess.CalledProcessError as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    generate_image()
