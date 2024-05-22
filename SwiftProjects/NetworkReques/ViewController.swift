//
//  ViewController.swift
//  NetworkReques
//
//  Created by Ualikhan Akberen on 10.11.2023.
//

import UIKit

struct HeroResponse: Decodable {
    struct Images: Decodable {
        let md: String
    }
    let id: Int
    let name: String
    let images: Images
}

class ViewController: UIViewController {
    
    @IBOutlet private weak var heroName: UILabel!
    @IBOutlet private weak var heroImage: UIImageView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        heroName.text = "Some Hero"
        heroImage.image = UIImage(systemName: "airplane")
    }
     
    @IBAction func onHeroButtonDidTap(_ sender: UIButton){
        getHero()
        
    }
    private func getHero(){
        print("Starting")
        let session = URLSession(configuration: .default)
        if let url = URL(string: "https://akabab.github.io/superhero-api/api/all.json" ) {
            let urlRequest = URLRequest(url: url)
            let task = session.dataTask(with: urlRequest) { data, response, error in
                if let error = error {
                    print("Error: \(error.localizedDescription)")
                } else {
                    if let safeData = data {
                        do {
                            _ = try JSONDecoder().decode([HeroResponse].self, from: safeData)
                        } catch {
                            print("Parsing error: \(error.localizedDescription)")
                        }
                    }
                }
            }
            task.resume()
        }
        
    }
}

